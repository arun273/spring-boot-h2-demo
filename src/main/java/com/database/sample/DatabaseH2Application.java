package com.database.sample;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DatabaseH2Application {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseH2Application.class, args);
    }

}
