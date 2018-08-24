package com.db.my_spring.di;

import com.db.my_spring.irobot.ConsoleSpeaker;
import com.db.my_spring.irobot.Speaker;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class JavaConfig implements Config {

    @Getter
    private Map<Class<?>, Class<?>> config;

    public JavaConfig() {
        config = new HashMap<>();
        setConfig();
    }

    private void setConfig() {
        config.put(Speaker.class, ConsoleSpeaker.class);
    }

    @Override
    public Class<?> getImplClass(Class clazz) {
        return config.get(clazz);
    }
}
