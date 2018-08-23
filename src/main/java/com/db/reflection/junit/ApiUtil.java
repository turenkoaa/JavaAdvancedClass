package com.db.reflection.junit;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ApiUtil {

    @SneakyThrows
    public static void runAllRunMethods(String className) {
        Class<?> clazz = Class.forName(className);
        runAllRunMethods(clazz);
    }

    @SneakyThrows
    public static void runAllRunMethods(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();
        Object o = Arrays.stream(constructors).anyMatch(c -> c.getParameterCount() == 0)
                ? clazz.newInstance()
                : clazz.getConstructor(String.class).newInstance("string in constructor");
        runAllRunMethods(o);

    }

    @SneakyThrows
    public static void runAllRunMethods(Object o){
        Class<?> clazz = o.getClass();
        Method[] methods = clazz.getMethods();

        // todo why empty?
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().equals(int.class)) {
                field.setAccessible(true);
                field.set(o, 2);
            }
        }

        for (Method method : methods) {
            if (method.getName().startsWith("run") || method.isAnnotationPresent(RunThisMethod.class)) {
                RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
                if (annotation != null) {
                    int repeat = annotation.repeat();
                    for (int i = 0; i < repeat; i++) {
                        method.invoke(o);
                    }
                }
                method.invoke(o);
            }
        }
    }

    public static  void printApi(Object o) {
        Class<?> clazz = o.getClass();

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            System.out.println("methodName="+name);

        }

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            String name = field.getName();
            Class<?> type = field.getType();
            System.out.println(name);
            System.out.println(type);
        }

//        Class<?> superclass = clazz.getSuperclass();
//        int modifiers = clazz.getModifiers();
    }

    public static void main(String[] args) {
        ApiUtil.runAllRunMethods(DBService.class);
    }
}
