package com.db.my_spring.di;

import com.db.my_spring.di.annotations.PostConstruct;
import com.db.my_spring.di.config.Config;
import com.db.my_spring.di.config.JavaConfig;
import com.db.my_spring.di.object_configurator.ObjectConfigurator;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;


/*
loading class
methods are overrided on loading class

static init parent
static init son

parent inline / parent init in order
parent constructor

son inline / parent init in order
son constructor
*/

public class ObjectFactory {

    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config configuration = new JavaConfig();
    private Reflections scanner = new Reflections("com.db.my_spring");
    private Set<ObjectConfigurator> configurators = new HashSet<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> objectConfiguratorClasses = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> clazz : objectConfiguratorClasses) {
            if(!Modifier.isAbstract(clazz.getModifiers())){
                configurators.add(clazz.newInstance());
            }
        }
    }

    // Beans MUST have empty constructor
    // Beans MUST have init method with special annotation @PostConstruct - without parameters
    @SneakyThrows
    public <T> T createObject(Class<T> type){
        type = resolveImpl(type);
        T t = (T) type.newInstance();
        configure(t);
        invokeInitMethod(t);

        return t;
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()){
            Class<?> implClass = configuration.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more then 1 impl, please update new config.");
                }
                implClass = classes.iterator().next();
            }
            type = (Class<T>) implClass;
        }
        return type;
    }

    private <T> void configure(T t) throws Exception {
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(t);
        }
    }

    @SneakyThrows
    private void invokeInitMethod(Object t) {
        Class<?> clazz = t.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.setAccessible(true);
                method.invoke(t);
            }
        }
    }


}
