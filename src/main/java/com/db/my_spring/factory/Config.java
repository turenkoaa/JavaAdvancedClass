package com.db.my_spring.factory;

public interface Config {
    Class<?> getImplClass(Class<?> clazz);
}
