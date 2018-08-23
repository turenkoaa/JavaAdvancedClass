package com.db.design_patterns.solid;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Random;

public class LowLevelOperandGenerator implements RandomGenerator {

    private DataFactory dataFactory;

    public LowLevelOperandGenerator() {
        dataFactory = new DataFactory();
    }

    @Override
    public int generateValue() {
        return dataFactory.getNumberBetween(0,10);
    }
}
