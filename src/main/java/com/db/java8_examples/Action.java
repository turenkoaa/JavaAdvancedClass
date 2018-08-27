package com.db.java8_examples;

@FunctionalInterface
public interface Action<T> {
    void doIt(T t);
}
