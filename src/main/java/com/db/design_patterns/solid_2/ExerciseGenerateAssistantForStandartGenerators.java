package com.db.design_patterns.solid_2;

import com.db.heroes.factory.RandomFactory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExerciseGenerateAssistantForStandartGenerators implements ExerciseGenerateAssistant {
    private int min, max;

    @Override
    public Exercise generateTemplate() {
        int a = RandomFactory.getInstance().getRandomBetween(min, max);
        int b = RandomFactory.getInstance().getRandomBetween(min, max);
        return Exercise.builder().a(a).b(b).build();
    }
}
