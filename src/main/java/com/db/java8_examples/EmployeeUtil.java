package com.db.java8_examples;

import java.util.Arrays;
import java.util.List;
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

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Hirsh", 10000), new Employee("Avishay", 20000), new Employee("Hadas", 30000));
        System.out.println("Sum of the salaries: " + totalSalary(employees));
        System.out.println(joinNames(employees));
    }


}
