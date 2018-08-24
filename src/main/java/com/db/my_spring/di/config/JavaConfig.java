package com.db.my_spring.di.config;

import com.db.my_spring.di.BenchmarkCleaner;
import com.db.my_spring.irobot.Cleaner;
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
        config.put(Cleaner.class, BenchmarkCleaner.class);
    }

    @Override
    public Class<?> getImplClass(Class clazz) {
        return config.get(clazz);
    }
}
