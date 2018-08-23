package com.db.design_patterns.builder;

import org.junit.Test;

public class PersonTest {

    @Test(expected = IllegalStateException.class)
    public void salaryWasNotSettedTest(){
        Person.builder().name("Nastya").age(18).build();
    }

    @Test(expected = AlreadyInUseException.class)
    public void builderCanNotBeUsedMoreThanOnceTest(){
        Person.PersonBuilder builder = Person.builder();
        builder.name("Nastya").age(18).salary(100).build();
        builder.name("Oleg").age(20).build();
    }

}