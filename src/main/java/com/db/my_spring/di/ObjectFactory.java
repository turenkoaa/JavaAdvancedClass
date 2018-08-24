package com.db.my_spring.di;

import com.db.my_spring.irobot.InjectRandomInt;
import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {

    private Config configuration = new JavaConfig();
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Reflections scanner = new Reflections("com.db.my_spring");
    private PostProcessor postProcessor = PostProcessor.getInstance();
    private List<Method> postProcessorMethodsWithObjectParameter;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {

        Method[] postProcessorMethods = postProcessor.getClass().getMethods();
        postProcessorMethodsWithObjectParameter = new ArrayList<>();
        for (Method postProcessorMethod : postProcessorMethods) {
            if (postProcessorMethod.getParameterCount() == 1 && postProcessorMethod.getParameterTypes()[0] == Object.class)
                postProcessorMethodsWithObjectParameter.add(postProcessorMethod);
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type){
        T t = createImpByInterfaceType(type);
        invokeAllPostProcessorMethods(t);
        return t;
    }

    private <T> T createImpByInterfaceType(Class<T> type) throws InstantiationException, IllegalAccessException {
        if (type.isInterface()){
            Class<?> implClass = configuration.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more impl.");
                }
                implClass = classes.iterator().next();
            }
            type = (Class<T>) implClass;
        }

        return (T) type.newInstance();
    }

    @SneakyThrows
    private void invokeAllPostProcessorMethods(Object t){
        for (Method method : postProcessorMethodsWithObjectParameter) {
            method.invoke(postProcessor, t);
        }
    }


}
