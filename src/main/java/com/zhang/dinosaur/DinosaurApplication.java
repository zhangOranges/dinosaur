package com.zhang.dinosaur;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * endpoint
 */
@SpringBootApplication
public class DinosaurApplication {
    /**
     * Dinosaur roar
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DinosaurApplication.class, args);
    }


}
