package com.db.java8_examples;

import lombok.SneakyThrows;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextUtil {


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(TextUtil.class.getClassLoader().getResourceAsStream("text.txt")))) {
            List<String> lines = reader.lines().collect(Collectors.toList());
            long countWords = lines.stream()
                    .flatMap(line -> Arrays.stream(line.split("\\P{L}+")))
                    .count();
            System.out.println("There are " + countWords + " words");

            double average = lines.stream()
                    .flatMap(line -> Arrays.stream(line.split("\\P{L}+")))
                    .mapToInt(String::length)
                    .average()
                    .orElse(0f);
            System.out.println("The avg length is " + average);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
