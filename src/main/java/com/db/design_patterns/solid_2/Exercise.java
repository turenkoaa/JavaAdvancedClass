package com.db.design_patterns.solid_2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Exercise {
    private Operation operation;
    private int a;
    private int b;
    private int answer;

    @Override
    public String toString() {
        return "Exercise: " + a + operation + b + "=" + answer;
    }
}
