package com.db.design_patterns.solid.operator;

public interface BinaryOperator {
    int calculate(int operand1, int operand2);
    String getSign();
}
