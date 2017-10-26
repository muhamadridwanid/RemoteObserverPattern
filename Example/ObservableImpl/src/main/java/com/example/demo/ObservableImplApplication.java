package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ObservableImplApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(ObservableImplApplication.class, args);
    }

    public void run(String... strings) throws Exception {
        Config config = context.getBean(Config.class);
        config.init();

        config.fireChanged();
    }
}
