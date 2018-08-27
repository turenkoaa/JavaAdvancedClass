package com.db.java8_examples;


import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ListUtil {
    public  static <T> int countDuplicates(List<T> list, T t, Equalator<T> equalator){
        int counter = 0;
        for (T item : list) {
            if (equalator.equals(item, t)) {
                counter++;
            }
        }
        return counter;
    }

    @SneakyThrows
    public static <T> void forEachWithDelay(List<T> list, int delay, Action<T> consumer){
        for (T item : list) {
            Thread.sleep(delay);
            consumer.doIt(item);
        }

    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "JAVA", "JAVA");
        int duplicates = countDuplicates(strings, "java", (t1, t2) -> t1.length() == t2.length());
        forEachWithDelay(strings, 500, new Action<String>() {
            @Override
            public void doIt(String s) {
                this.getClass();
            }
        });

    }
}
