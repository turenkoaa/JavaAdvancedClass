package com.db.java8_examples;

@FunctionalInterface
public interface Equalator<T> {
    boolean equals(T t1, T t2);
}
