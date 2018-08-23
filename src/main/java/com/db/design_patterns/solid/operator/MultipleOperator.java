package com.db.design_patterns.solid.operator;

public class MultipleOperator implements BinaryOperator{

    private final String SIGN = "*";

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 * operand2;
    }

    @Override
    public String getSign() {
        return SIGN;
    }
}
