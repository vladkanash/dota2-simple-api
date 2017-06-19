package com.vladkanash.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by vladk on 16.06.2017.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.vladkanash"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
