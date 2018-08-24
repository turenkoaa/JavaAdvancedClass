package com.db.my_spring.di.object_configurator;

import com.db.my_spring.di.ObjectFactory;
import com.db.my_spring.di.annotations.InjectByType;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

public class InjectByTypeAnnotationConfigurator implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public void configure(Object t){
        Class<?> type = t.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(type);
            for (Field field : fields) {
                if (field.isAnnotationPresent(InjectByType.class)){
                    field.setAccessible(true);
                    Object injected = ObjectFactory.getInstance().createObject(field.getType());
                    field.set(t, injected);
                }
            }


    }
}
