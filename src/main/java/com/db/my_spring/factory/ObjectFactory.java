package com.db.my_spring.factory;

import com.db.my_spring.irobot.InjectRandomInt;
import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Set;

public class ObjectFactory {

    private Config configuration = new JavaConfig();
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Reflections scanner = new Reflections("com.db.my_spring");
    private DataFactory dataFactory = new DataFactory();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {}

    @SneakyThrows
    public <T> T createObject(Class<T> type){

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

        T t = type.newInstance();

        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)){
                field.setAccessible(true);
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                field.set(t, dataFactory.getNumberBetween(annotation.min(), annotation.max()));
            }
        }

        return t;
    }
}
