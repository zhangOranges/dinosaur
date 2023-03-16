package com.zhang.dinosaur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
