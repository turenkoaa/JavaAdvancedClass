package com.db.design_patterns.solid_2;

import org.springframework.beans.factory.annotation.Autowired;

@Levels(level = Level.ШКОЛА)
public class MinusДляШкольников implements ExerciseGenerator {
    @Autowired
    private ExerciseGenerateAssistant assistant;

    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperation(Operation.MINUS);
        exercise.setAnswer(exercise.getA() - exercise.getB());
        return exercise;
    }
}
