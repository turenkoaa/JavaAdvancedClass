package com.db.my_spring.irobot;

import javax.swing.*;

public class PopUpSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
