package com.db.my_spring.di.object_configurator;

import com.db.heroes.factory.RandomFactory;
import com.db.my_spring.di.annotations.InjectRandomInt;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

public class InjectRandomIntAnnotationConfigurator implements ObjectConfigurator {
    @Override
    public void configure(Object t)throws Exception{
        Class<?> type = t.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(type);
        RandomFactory randomFactory = RandomFactory.getInstance();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)){
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                field.setAccessible(true);
                int min = annotation.min();
                int max = annotation.max();
                int value = randomFactory.getRandomBetween(min, max);
                field.set(t, value);
            }
        }
    }
}
