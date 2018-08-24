package com.db.my_spring.di;

import com.db.my_spring.irobot.Benchmark;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Optional;
import java.util.Set;

public class BenchmarkProxyConfigurator implements ProxyConfigurator {

    @Override
    @SuppressWarnings("unchecked")
    public Object wrapProxy(Object t, Class<?> type) {

        Optional<Method> first = ReflectionUtils.getAllMethods(type)
                .stream()
                .filter(m -> m.isAnnotationPresent(Benchmark.class))
                .findFirst();

        if (!type.isAnnotationPresent(Benchmark.class) && !first.isPresent()) {
            return t;
        } else {
            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(),
                    (proxy, method, args) -> {
                        Object retVal;
                        if (type.getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(Benchmark.class)) {
                            System.out.println("************** benchmark for method " + method.getName() + " started ***************");
                            long start = System.nanoTime();
                            retVal = method.invoke(t, args);
                            long end = System.nanoTime();
                            System.out.println("Method " + method.getName() + ": " + (end - start) + " nanoseconds");
                            System.out.println("************** benchmark for method " + method.getName() + " finished ***************");

                        } else {
                            retVal = method.invoke(t, args);
                        }
                        return retVal;
                    });
        }
    }
}
