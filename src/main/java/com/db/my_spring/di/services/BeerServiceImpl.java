package com.db.my_spring.di.services;

import com.db.my_spring.irobot.Benchmark;

public class BeerServiceImpl implements BeerService {

    @Benchmark
    @Override
    public void drinkBeer() {
        System.out.println("I m drinking.");
    }

    @Override
    public void goToToilet() {
        System.out.println("pssssssssss");
    }
}
