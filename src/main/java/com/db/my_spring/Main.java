package com.db.my_spring;

import com.db.my_spring.di.ObjectFactory;
import com.db.my_spring.irobot.IRobot;
import com.db.my_spring.services.BeerService;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        IRobot robot = ObjectFactory.getInstance().createObject(IRobot.class);
        System.out.println(robot.getClass().getName());
        while (true) {
            Thread.sleep(8000);
            robot.cleanRoom();
        }
//        BeerService beerService = ObjectFactory.getInstance().createObject(BeerService.class);
//        beerService.a();
    }
}
