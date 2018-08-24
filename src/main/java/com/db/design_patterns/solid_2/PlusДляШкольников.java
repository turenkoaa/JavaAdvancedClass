package com.db.design_patterns.solid_2;

public class PlusДляШкольников implements ExerciseGenerator {

    private ExerciseGenerateAssistant assistant = new ExerciseGenerateAssistantForStandartGenerators(0, 10);;

    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateTemplate();
        exercise.setOperation(Operation.PLUS);
        exercise.setAnswer(exercise.getA() + exercise.getB());
        return exercise;
    }
}
