package com.db.my_spring.irobot;

import com.db.my_spring.di.annotations.Bean;
import com.db.my_spring.di.annotations.InjectRandomInt;
import com.db.my_spring.di.annotations.PostConstruct;

@Bean
public class CleanerImpl implements Cleaner {

    @InjectRandomInt(min = 3, max = 6)
    private int repeat;

    public CleanerImpl() {
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvv");
        }
    }
}
