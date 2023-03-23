package com.zhang.dinosaur.domain;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConfigEarthEnv extends Earth{

    @Override
    public void doSomeThing() {
        for (;;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.doSomeThing();
        }
    }

    @Override
    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
