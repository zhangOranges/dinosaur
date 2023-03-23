package com.zhang.dinosaur.event;

import com.zhang.dinosaur.domain.Animal;

public class ThunderEvent implements WeatherEvent{
    @Override
    public void fire(Animal animal) {
        animal.instinct();
    }
}
