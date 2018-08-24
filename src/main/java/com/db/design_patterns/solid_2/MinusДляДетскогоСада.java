package com.db.design_patterns.solid_2;

import com.db.heroes.factory.RandomFactory;

public class MinusДляДетскогоСада implements ExerciseGenerator {
    @Override
    public Exercise generate() {
        RandomFactory randomFactory = RandomFactory.getInstance();
        int a = randomFactory.getRandomBetween(0, 10);
        int b = randomFactory.getRandomBetween(0, a+1);
        return Exercise.builder()
                .a(a)
                .b(b)
                .operation(Operation.MINUS)
                .answer(a-b)
                .build();
    }
}
