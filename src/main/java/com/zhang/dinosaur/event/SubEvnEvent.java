package com.zhang.dinosaur.event;

import com.google.common.eventbus.Subscribe;

/**
 *As long as it is an object in the environment, it is necessary to implement this interface to complete the processing of the corresponding environment
 */
public interface SubEvnEvent {
    @Subscribe
    public void sub(EnvEvent envEvent);
}
