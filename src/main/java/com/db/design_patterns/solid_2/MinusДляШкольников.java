package com.db.design_patterns.solid_2;

public class MinusДляШкольников implements ExerciseGenerator {
    private ExerciseGenerateAssistant assistant = new ExerciseGenerateAssistantForStandartGenerators(0, 10);;

    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperation(Operation.MINUS);
        exercise.setAnswer(exercise.getA() - exercise.getB());
        return exercise;
    }
}
