package com.db.heroes.factory;

import org.fluttercode.datafactory.impl.DataFactory;

public class RandomFactory {

    private static DataFactory dataFactory = new DataFactory();

    private static RandomFactory ourInstance = new RandomFactory();

    public static RandomFactory getInstance() {
        return ourInstance;
    }

    private RandomFactory() {
    }

    public int getRandomBetween(int min, int max) {
        return dataFactory.getNumberBetween(min, max);
    }
}
