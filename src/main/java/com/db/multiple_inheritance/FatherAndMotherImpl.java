package com.db.multiple_inheritance;

public class FatherAndMotherImpl implements Father, Mother {
    @Override
    public void speak() {
        Father.super.speak();
        Mother.super.speak();
    }
}
