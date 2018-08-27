package com.db.java8_examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class TextUtil {

    public static Map<String, Integer> findWordsFrequency(BufferedReader reader){
        return reader.lines()
                .flatMap(line -> Arrays.stream(line.split("\\P{L}+")))
                .collect(toMap(w -> w, w -> 1, (v1, v2) -> v1 + 1));
    }

    private static long findWordsAndCount(BufferedReader reader) {
        List<String> lines = reader.lines().collect(Collectors.toList());
        return lines.stream()
                .flatMap(line -> Arrays.stream(line.split("\\P{L}+")))
                .count();
    }

    private static double fingAvgLength(BufferedReader reader) {
        return reader.lines()
                .flatMap(line -> Arrays.stream(line.split("\\P{L}+")))
                .mapToInt(String::length)
                .average()
                .orElse(0f);
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(TextUtil.class.getClassLoader().getResourceAsStream("text.txt")));
        Map<String, Integer> wordsFrequency = findWordsFrequency(reader);
        System.out.println(wordsFrequency);
    }
}
