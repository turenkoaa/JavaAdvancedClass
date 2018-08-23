package com.db.design_patterns.solid;

public class MathExerciseWriter {

    public void writeExercise(MathExercise exercise) {
        StringBuilder stringBuilder = new StringBuilder();
        String exerciseString = stringBuilder
                .append("Exercise: ")
                .append(exercise.getOperand1())
                .append(exercise.getOperator().getSign())
                .append(exercise.getOperand2())
                .append(" = ")
                .append(exercise.getResult())
                .toString();

        System.out.println(exerciseString);
    }
}
