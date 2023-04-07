package com.zhang.dinosaur;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * endpoint
 */
@SpringBootApplication
@Slf4j
public class DinosaurApplication {
    /**
     * Dinosaur roar
     * @param args
     */
    public static void main(String[] args) {
//        System.setProperty(PropertyUtils.BOOTSTRAP_ENABLED_PROPERTY,"true");
        SpringApplication.run(DinosaurApplication.class, args);

    }


}
