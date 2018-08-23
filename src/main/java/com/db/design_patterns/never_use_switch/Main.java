package com.db.design_patterns.never_use_switch;

import lombok.SneakyThrows;

import java.nio.file.FileAlreadyExistsException;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        MailSender mailSender = new MailSender();
        while (true) {
            try {
                mailSender.sendMail();

            } catch (RuntimeException e) {
                System.out.println(e);
            }
            Thread.sleep(8);
        }


    }
}
