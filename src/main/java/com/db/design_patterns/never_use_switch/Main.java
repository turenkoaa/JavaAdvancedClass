package com.db.design_patterns.never_use_switch;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.file.FileAlreadyExistsException;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.db.design_patterns.never_use_switch");
        MailSender mailSender = context.getBean(MailSender.class);

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
