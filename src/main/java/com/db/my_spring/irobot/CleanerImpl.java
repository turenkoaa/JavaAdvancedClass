package com.db.my_spring.irobot;

public class CleanerImpl implements Cleaner {

    @InjectRandomInt(min = 3, max = 6)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvv");
        }
    }
}
