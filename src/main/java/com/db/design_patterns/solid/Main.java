package com.db.design_patterns.solid;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MathExerciseWriter exerciseWriter = new MathExerciseWriter();
        MathTestService mathTestService = new MathTestService();
        MathTestRequest request = MathTestRequest.builder()
                .amountOfExercises(20)
                .exerciseTypes(Arrays.asList("Plus", "Multi"))
                .level(1)
                .build();
        List<MathExercise> test = mathTestService.generateTest(request);
        test.forEach(exerciseWriter::writeExercise);
    }
}
