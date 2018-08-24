package com.db.design_patterns.solid_2;

import com.db.heroes.factory.RandomFactory;
import lombok.Builder;
import lombok.Singular;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Examinator {

    @Singular
    private List<ExerciseGenerator> generators;
    private final DataFactory dataFactory = new DataFactory();

    public List<Exercise> createExam(int amount){
        List<Exercise> exercises = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            exercises.add(dataFactory.getItem(generators).generate());
        }

        return exercises;
    }
}
