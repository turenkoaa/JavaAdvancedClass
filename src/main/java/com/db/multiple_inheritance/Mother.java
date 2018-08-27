package com.db.multiple_inheritance;

public interface Mother {
    default void speak() {
        System.out.println("ya mama");
    }
}