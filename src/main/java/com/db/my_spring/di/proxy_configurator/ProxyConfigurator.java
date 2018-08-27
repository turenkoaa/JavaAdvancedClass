package com.db.my_spring.di.proxy_configurator;

public interface ProxyConfigurator {
    Object wrapWithProxy(Object t, Class<?> type) throws Exception;
}
