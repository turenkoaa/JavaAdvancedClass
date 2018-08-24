package com.db.design_patterns.solid_2;

public class Main {
    public static void main(String[] args) {
        Examinator examinator = Examinator.builder()
                .generator(new PlusДляШкольников())
                .generator(new MinusДляДетскогоСада())
                .build();

        examinator.createExam(10).forEach(e -> System.out.println(e));
    }
}
