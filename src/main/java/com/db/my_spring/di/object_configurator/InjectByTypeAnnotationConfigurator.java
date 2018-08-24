package com.db.my_spring.di.object_configurator;

import com.db.my_spring.di.ObjectFactory;
import com.db.my_spring.irobot.InjectByType;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationConfigurator implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public void configure(Object t){
        Class<?> type = t.getClass();
        Field[] declaredFields = type.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(InjectByType.class)){
                    field.setAccessible(true);
                    Object injected = ObjectFactory.getInstance().createObject(field.getType());
                    field.set(t, injected);
                }
            }


    }
}
