package com.db.my_spring.irobot;

import com.db.my_spring.di.annotations.Bean;
import com.db.my_spring.di.annotations.InjectByType;
import com.db.my_spring.di.annotations.PostConstruct;

@Bean
public class IRobot {

    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public IRobot() {
        System.out.println();
    }

    @PostConstruct
    public void init() {

    }

    public void cleanRoom(){
        speaker.speak("Start work.");
        cleaner.clean();
        speaker.speak("End work.");
    }
}