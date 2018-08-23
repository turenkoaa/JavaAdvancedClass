package com.db.annonimous_inner_classes;

import com.db.heroes.character.Hobbit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleFrame extends JFrame {

    public SimpleFrame(String title) throws HeadlessException {
        JButton button = new JButton("click me");
        Hobbit hobbit = new Hobbit();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hobbit.decreaseHp(5);
                System.out.println(hobbit);
            }
        });


        getContentPane().add(button, BorderLayout.NORTH);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SimpleFrame("ok");
    }
}
