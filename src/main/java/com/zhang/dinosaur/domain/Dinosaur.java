package com.zhang.dinosaur.domain;

import com.zhang.dinosaur.config.TestConfig;
import com.zhang.dinosaur.event.*;
import com.zhang.dinosaur.listener.EnvEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * dinosaur class
 */
@Slf4j
@Component
public class Dinosaur implements Animal, EnvEventListener, SubEvnEvent {
    /**
     * current dinosaur hold this environmentEvent
     */
    private EnvEvent envEvent;
    @Autowired
    private TestConfig testConfig;
    @Override
    public void born() {
        log.info("Dinosaur born");
    }

    @Override
    public void death() {
        log.error("Dinosaur death");
    }

    @Override
    public void action(Env env) {
        log.info("Dinosaur action  time = {} name = {}",env.getNow(),testConfig.getName());
        if ( envEvent != null){
           envEvent.fire(this);
        }else{
            eat();
            roar();
        }
    }

    @Override
    public void instinct() {
        EnvEvent temp = envEvent;
        if ( temp != null){
            if (temp instanceof WindEvent){
                log.info("Dinosaur goto home at {}",temp.getClass());
            }else if (temp instanceof RainEvent){
                log.info("Dinosaur goto home at {}",temp.getClass());
            }else if (temp instanceof ThunderEvent){
                log.info("Dinosaur goto home at {}",temp.getClass());
            }else {
                log.info("Dinosaur no event instinct on = {}",temp.getClass());
            }
        }else{
           log.info("Dinosaur no event instinct");
        }
    }

    private void eat(){
        log.info("eat action");
    }
    private void roar(){
        log.info("roar action");
    }

    @Override
    public void sub(EnvEvent envEvent) {
        this.envEvent = envEvent;
        log.info("env Event = {} ",envEvent.getClass());
        log.error("{}",this.toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.envEvent = null;
    }
}
