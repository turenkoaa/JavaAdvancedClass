package com.db.design_patterns.solid_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Levels(level = Level.ШКОЛА)
public class PlusДляШкольников implements ExerciseGenerator {

    @Autowired
    private ExerciseGenerateAssistant assistant;

    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperation(Operation.PLUS);
        exercise.setAnswer(exercise.getA() + exercise.getB());
        return exercise;
    }
}
