package com.zhang.dinosaur.game.bus;

import com.google.common.eventbus.EventBus;
import com.zhang.dinosaur.game.cs.event.EventObject;
import com.zhang.dinosaur.game.cs.listener.EventListener;


/**
 * event bus
 */
public class GContextEventBus {
    private static EventBus eventBus = new EventBus();

    public synchronized static void register(EventListener eventListener){
        eventBus.register(eventListener);
    }

    public static void post(EventObject o){
        eventBus.post(o);
    }
}
