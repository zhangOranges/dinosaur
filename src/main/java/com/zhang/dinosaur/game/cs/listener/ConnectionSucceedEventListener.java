package com.zhang.dinosaur.game.cs.listener;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.cs.event.ConnectionSucceedEvent;

public interface ConnectionSucceedEventListener<T extends ConnectionSucceedEvent> extends EventListener{

    @Subscribe
    public void action(T o);
}
