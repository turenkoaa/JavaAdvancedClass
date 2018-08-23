package com.db.my_spring.irobot;

import com.db.my_spring.factory.ObjectFactory;

public class IRobot {
    private Speaker speaker = ObjectFactory.getInstance().createObject(Speaker.class);
    private Cleaner cleaner = ObjectFactory.getInstance().createObject(Cleaner.class);

    public void cleanRoom(){
        speaker.speak("Start work.");
        cleaner.clean();
        speaker.speak("End work.");
    }
}