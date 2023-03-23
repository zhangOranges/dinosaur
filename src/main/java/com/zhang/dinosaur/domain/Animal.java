package com.zhang.dinosaur.domain;

/**
 * Represents organisms in the environment
 */
public interface Animal {
    Animal born();
    void death();
    void action(Env env);
}
