package com.db.design_patterns.solid;

import com.db.design_patterns.solid.operator.BinaryOperator;
import lombok.Setter;


public class MathExerciseGenerator implements ExerciseGenerator {

    @Setter
    private BinaryOperator binaryOperator;
    private RandomGenerator randomGenerator;

    public MathExerciseGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public MathExercise generate() {
        return MathExercise.builder()
                .operand1(randomGenerator.generateValue())
                .operand2(randomGenerator.generateValue())
                .operator(binaryOperator)
                .build();
    }
}
