package com.zhang.dinosaur.event;

import com.zhang.dinosaur.domain.Animal;

/**
 * Represents an event in your environment
 */
public interface EnvEvent {
    void fire(Animal animal);
}
