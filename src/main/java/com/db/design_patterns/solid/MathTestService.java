package com.db.design_patterns.solid;

import com.db.design_patterns.solid.operator.BinaryOperator;
import com.db.design_patterns.solid.operator.MultipleOperator;
import com.db.design_patterns.solid.operator.PlusOperator;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.*;
import java.util.stream.Collectors;

public class MathTestService {

    private Map<String, BinaryOperator> operatorMap;
    private Map<Integer, RandomGenerator> randomGeneratorMap;
    private DataFactory dataFactory;

    public MathTestService() {
        dataFactory = new DataFactory();
        init();
    }

    private void init() {
        operatorMap = new HashMap<>();
        operatorMap.put("Plus", new PlusOperator());
        operatorMap.put("Multi", new MultipleOperator());

        randomGeneratorMap = new HashMap<>();
        randomGeneratorMap.put(1, new LowLevelOperandGenerator());
    }

    public List<MathExercise> generateTest(MathTestRequest request){

        List<MathExercise> exercises = new ArrayList<>();
        RandomGenerator randomGenerator = randomGeneratorMap.get(request.getLevel());
        List<BinaryOperator> operators = request.getExerciseTypes()
                .stream()
                .map(t -> operatorMap.get(t))
                .collect(Collectors.toList());

        MathExerciseGenerator mathExerciseGenerator = new MathExerciseGenerator(randomGenerator);

        int amountOfExercises = request.getAmountOfExercises();
        for (int i = 0; i < amountOfExercises; i++) {
            mathExerciseGenerator.setBinaryOperator(operators.get(dataFactory.getNumberBetween(0, operators.size())));
            exercises.add(mathExerciseGenerator.generate());

        }

        return exercises;
    }

}
