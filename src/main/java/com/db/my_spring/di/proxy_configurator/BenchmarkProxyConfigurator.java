package com.db.my_spring.di.proxy_configurator;

import com.db.my_spring.di.mbeans.BenchmarkToggle;
import com.db.my_spring.irobot.Benchmark;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BenchmarkProxyConfigurator implements ProxyConfigurator {

//    @InjectByType
    private BenchmarkToggle benchmarkToggle = new BenchmarkToggle();

    @Override
    @SuppressWarnings("unchecked")
    public Object wrapWithProxy(Object t, Class<?> type) {

        boolean methodNeedTheBenchmark = ReflectionUtils.getAllMethods(type)
                .stream()
                .anyMatch(m -> m.isAnnotationPresent(Benchmark.class));

        if (type.isAnnotationPresent(Benchmark.class) || methodNeedTheBenchmark) {
            if (type.getInterfaces().length == 0){
                return Enhancer.create(type, (InvocationHandler) (o, method, args) -> BenchmarkProxyConfigurator.this.invoke(method, args, type, t));
            } else {
                return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> BenchmarkProxyConfigurator.this.invoke(method, args, type, t));
            }
        }

        return t;
    }

    @SneakyThrows
    private Object invoke(Method method, Object[] args, Class<?> type, Object t) {
        Method targetMethod = type.getMethod(method.getName(), method.getParameterTypes());
        Object retVal;
        if (benchmarkToggle.isEnabled() && (type.isAnnotationPresent(Benchmark.class) || targetMethod.isAnnotationPresent(Benchmark.class))) {
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
    }
}
