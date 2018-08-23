package com.db.design_patterns.solid;

import com.db.design_patterns.solid.operator.BinaryOperator;
import lombok.Value;

@Value
public class MathExercise {

    private BinaryOperator operator;

    private Integer operand1;

    private Integer operand2;

    private Integer result;

    private MathExercise(BinaryOperator operator, Integer operand1, Integer operand2, Integer result) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    public static MathExerciseBuilder builder() {
        return new MathExerciseBuilder();
    }

    public static class MathExerciseBuilder {
        private BinaryOperator operator;
        private Integer operand1;
        private Integer operand2;
        private Integer result;

        MathExerciseBuilder() {
        }

        public MathExerciseBuilder operator(BinaryOperator operator) {
            this.operator = operator;
            return this;
        }

        public MathExerciseBuilder operand1(Integer operand1) {
            this.operand1 = operand1;
            return this;
        }

        public MathExerciseBuilder operand2(Integer operand2) {
            this.operand2 = operand2;
            return this;
        }

        public MathExercise build() {
            result = operator.calculate(operand1, operand2);
            return new MathExercise(operator, operand1, operand2, result);
        }
    }
}
