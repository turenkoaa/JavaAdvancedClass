package com.db.java8_examples;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WeekDaysUtil {

    public static Map<Integer, Long> findBlackFriday(int startYear, int endYear){
        LocalDate startDate = LocalDate.of(startYear, Month.JANUARY, 13);
        LocalDate endDate = LocalDate.of(endYear, Month.DECEMBER, 13);

        return Stream.iterate(startDate, d -> d.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(startDate, endDate))
                .filter(d -> d.getDayOfWeek()==DayOfWeek.FRIDAY)
                .collect(Collectors.groupingBy(LocalDate::getYear, () -> new TreeMap<>(Integer::compare), Collectors.counting()));
    }

    public static void main(String[] args) {
        Map<Integer, Long> blackFridays = findBlackFriday(1980, 1990);
        System.out.println(blackFridays);

    }
}
