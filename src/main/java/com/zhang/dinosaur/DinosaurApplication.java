package com.zhang.dinosaur;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.util.PropertyUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

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
//        System.setProperty(PropertyUtils.BOOTSTRAP_ENABLED_PROPERTY,"true");
        SpringApplication.run(DinosaurApplication.class, args);
    }


}
