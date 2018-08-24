package com.db.my_spring.irobot;

@Bean
public class IRobot {

    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void cleanRoom(){
        speaker.speak("Start work.");
        cleaner.clean();
        speaker.speak("End work.");
    }
}