package com.db.my_spring.irobot;

import com.db.my_spring.di.annotations.Bean;

@Bean
public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
