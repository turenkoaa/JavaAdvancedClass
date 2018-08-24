package com.db.my_spring.di;

public interface ProxyConfigurator {
    Object wrapProxy(Object t, Class<?> type) throws Exception;
}
