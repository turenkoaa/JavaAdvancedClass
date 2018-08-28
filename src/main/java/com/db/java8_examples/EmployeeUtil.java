package com.db.java8_examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeUtil {

    public static int totalSalary(List<Employee> list) {
        Integer total = list.stream()
                .map(Employee::getSalary)
                .reduce(Integer::sum)
                .orElse(0);

        return list.stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public static String joinNames(List<Employee> list) {
        return list.stream()
                .map(e -> new StringBuilder(e.getName()))
                .reduce((stringBuilder, s) -> stringBuilder.append(",").append(s))
                .orElseGet(StringBuilder::new)
                .toString();

//        return list.stream()
//                .map(Employee::getName)
//                .collect(Collectors.joining(","));
    }

    public static Map<Level, List<Employee>> groupingEmployeesByLevel(List<Employee> list){
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getLevel, Collectors.toList()));
    }

    public static Map<Level, List<Employee>> mapByLevel(List<Employee> list){
        return list.stream().collect(Collectors.groupingBy(e-> Level.findBySalary(e.getSalary())));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Hirsh", 10, Level.SENIOR),
                new Employee("Avishay", 1500, Level.JUNIOR),
                new Employee("Hadas", 30000, Level.SENIOR)
        );
        System.out.println(mapByLevel(employees));
    }


}
