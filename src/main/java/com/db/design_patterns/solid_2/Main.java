package com.db.design_patterns.solid_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Examinator examinator = Examinator.builder()
//                .generator(new PlusДляШкольников())
//                .generator(new MinusДляДетскогоСада())
//                .build();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.db.design_patterns.solid_2");
        Examinator examinator = context.getBean(Examinator.class);

        examinator.createExam(10).forEach(e -> System.out.println(e));
    }
}
