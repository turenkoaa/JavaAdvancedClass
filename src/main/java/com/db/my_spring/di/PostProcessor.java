package com.db.my_spring.di;

import com.db.my_spring.irobot.InjectRandomInt;
import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

import java.lang.reflect.Field;

public class PostProcessor {
    private static PostProcessor ourInstance = new PostProcessor();
    private DataFactory dataFactory = new DataFactory();

    public static PostProcessor getInstance() {
        return ourInstance;
    }

    private PostProcessor() {
    }

    @SneakyThrows
    public void injectFields(Object t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)){
                field.setAccessible(true);
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                field.set(t, dataFactory.getNumberBetween(annotation.min(), annotation.max()));
            }
        }
    }
}
