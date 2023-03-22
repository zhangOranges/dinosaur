package com.zhang.dinosaur.domain;


import java.time.LocalDateTime;

/**
 * abstract env
 */
public abstract class Env {

    //Fields
    protected LocalDateTime now;
    //Methods
    public abstract void init();
    public abstract void doSomeThing();
    public abstract void destroy();

    public LocalDateTime getNow() {
        return now;
    }
}
