package com.db.java8_examples;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum Level {
    JUNIOR(0, 1000),
    MIDDLE(1001, 3000),
    SENIOR(3000, Integer.MAX_VALUE);

    private final int min;
    private final int max;

    public static Level findBySalary(int salary){
        return Arrays.stream(values())
                .filter(level -> level.min<=salary && salary<=level.max)
                .findAny()
                .get();
    }

}
