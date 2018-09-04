package com.db.design_patterns.never_use_switch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EnableScheduling
public class JavaConfig {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(JavaConfig.class);
    }
}
