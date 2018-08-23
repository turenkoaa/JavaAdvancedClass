package com.db.design_patterns.builder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Person {

    private final String name;
    private final int age;
    private final int salary;

    public Person withSalary(int salary) {
        return builder()
                .name(name)
                .age(age)
                .salary(salary)
                .build();
    }

    private Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private String name;
        private Integer age;
        private Integer salary;
        private boolean wasUsed = false;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder salary(int salary) {
            this.salary = salary;
            return this;
        }

        public Person build() {
            validate();
            wasUsed = true;
            return new Person(name, age, salary);
        }

        private void validate() {
            if (wasUsed)
                throw new AlreadyInUseException("Builder in use");
            if (salary == null)
                throw new IllegalStateException("Salary is null");
        }
    }


}
