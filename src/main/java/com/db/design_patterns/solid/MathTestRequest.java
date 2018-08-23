package com.db.design_patterns.solid;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MathTestRequest {
    public int amountOfExercises;
    private int level;
    private List<String> exerciseTypes;
}
