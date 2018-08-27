package com.db.my_spring.services;

import com.db.my_spring.irobot.Benchmark;

public class BeerServiceImpl implements BeerService {

    @Override
    public void drinkBeer() {
        System.out.println("I m drinking.");
    }

    @Override
    public void goToToilet() {
        System.out.println("pssssssssss");
    }

    // problem with design pattern Dynamic Proxy
    @Override
    public void a() {
        System.out.println("a()");
        this.b();
    }

    @Benchmark
    @Override
    public void b() {
        System.out.println("b()");
    }
}
