package com.db.multiple_inheritance;

public interface Father {
    default void speak() {
        System.out.println("ia father");
    }
}
