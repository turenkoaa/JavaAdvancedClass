package com.db.java8_examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class TextUtil {

    private static long findWordsAndCount(BufferedReader reader) {
        List<String> lines = reader.lines().collect(Collectors.toList());
        return lines.stream()
                .flatMap(line -> Arrays.stream(line.split("\\P{L}+")))
                .count();
    }

    private static double findAvgLength(BufferedReader reader) {
        return reader.lines()
                .flatMap(line -> Arrays.stream(line.split("\\P{L}+")))
                .mapToInt(String::length)
                .average()
                .orElse(0f);
    }

    public static Map<String, Integer> findWordsFrequency(BufferedReader reader){
        return reader.lines()
                .flatMap(line -> Arrays.stream(line.split("\\P{L}+")))
                .collect(toMap(
                        String::toLowerCase,
                        w -> 1,
                        (v1, v2) -> v1 + 1));
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(TextUtil.class.getClassLoader().getResourceAsStream("text.txt")));
        Map.Entry<String, Integer> mostFrequently = findWordsFrequency(reader)
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .orElseThrow(IllegalStateException::new);
        System.out.println(mostFrequently.getKey() + ": " + mostFrequently.getValue());
    }
}
