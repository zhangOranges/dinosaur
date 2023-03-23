package com.zhang.dinosaur.domain;

/**
 * Represents organisms in the environment
 */
public interface Animal {
    void born();
    void death();
    void action(Env env);
    void instinct();
}
