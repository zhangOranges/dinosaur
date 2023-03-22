package com.zhang.dinosaur.domain;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.WeatherListener;
import com.zhang.dinosaur.event.WeatherEvent;
import com.zhang.dinosaur.event.WindEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * dinosaur class
 */
@Slf4j
@Component
public class Dinosaur implements Animal, WeatherListener {
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
    public void action() {
        log.info("Dinosaur action");
        eat();
        roar();
    }

    private void eat(){
        log.info("eat action");
    }
    private void roar(){
        log.info("roar action");
    }
    @Subscribe
    public void wind(WindEvent windEvent){
        log.info("weatherEvent action = {}",windEvent.getClass());
        log.info("Dinosaur action = {}","Hide in the house");
    }
}
