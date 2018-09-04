package com.db.design_patterns.solid_2;

import com.db.heroes.factory.RandomFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@PropertySource("classpath:examinator.properties")
public class ExerciseGenerateAssistantForStandardGenerators implements ExerciseGenerateAssistant {

    @Value("${exercise.standard.generator.operand.min}")
    private int min;
    @Value("${exercise.standard.generator.operand.max}")
    private int max=10;


    @Override
    public Exercise generateTemplate() {
        int a = RandomFactory.getInstance().getRandomBetween(min, max);
        int b = RandomFactory.getInstance().getRandomBetween(min, max);
        return Exercise.builder().a(a).b(b).build();
    }
}
