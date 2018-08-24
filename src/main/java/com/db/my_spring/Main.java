package com.db.my_spring;

import com.db.my_spring.di.ObjectFactory;
import com.db.my_spring.irobot.IRobot;

public class Main {
    public static void main(String[] args) {
        ObjectFactory.getInstance().createObject(IRobot.class).cleanRoom();
    }
}
