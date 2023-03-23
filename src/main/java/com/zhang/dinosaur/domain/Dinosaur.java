package com.zhang.dinosaur.domain;

import com.zhang.dinosaur.event.EnvEvent;
import com.zhang.dinosaur.event.SubEvnEvent;
import com.zhang.dinosaur.listener.EnvEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * dinosaur class
 */
@Slf4j
@Component
public class Dinosaur implements Animal, EnvEventListener, SubEvnEvent {
    @Override
    public Animal born() {
        log.info("Dinosaur born");
        return new Dinosaur();
    }

    @Override
    public void death() {
        log.error("Dinosaur death");
    }

    @Override
    public void action(Env env) {
        log.info("Dinosaur action  time = {}",env.getNow());
        eat();
        roar();
    }

    private void eat(){
        log.info("eat action");
    }
    private void roar(){
        log.info("roar action");
    }

    @Override
    public void sub(EnvEvent envEvent) {
        log.info("env Event = {} ",envEvent.getClass());
    }
}
