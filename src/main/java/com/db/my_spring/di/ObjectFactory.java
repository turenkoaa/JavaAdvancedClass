package com.db.my_spring.di;

import com.db.my_spring.di.config.Config;
import com.db.my_spring.di.config.JavaConfig;
import com.db.my_spring.di.object_configurator.ObjectConfigurator;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.*;

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

    @SneakyThrows
    public <T> T createObject(Class<T> type){
        type = resolveImpl(type);
        T t = (T) type.newInstance();
        configure(t);

        return t;
    }

    private <T> void configure(T t) throws Exception {
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(t);
        }
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
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
        return type;
    }


}
