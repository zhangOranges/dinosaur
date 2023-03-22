package com.zhang.dinosaur.domain;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConfigEarthEnv extends Earth implements ConfigEnv{

    @Override
    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    @Override
    public void doSomeThing() {
        for (;;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setNow(LocalDateTime.now());
            super.doSomeThing();
        }
    }
}
