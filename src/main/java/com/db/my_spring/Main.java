package com.db.my_spring;

import com.db.my_spring.di.ObjectFactory;
import com.db.my_spring.di.services.BeerService;
import com.db.my_spring.irobot.IRobot;

public class Main {
    public static void main(String[] args) {
        BeerService beerService = ObjectFactory.getInstance().createObject(BeerService.class);
        beerService.drinkBeer();
        beerService.goToToilet();
    }
}
