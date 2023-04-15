package com.zhang.dinosaur.game.cs.listener;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.cs.event.ConnectionSucceedEvent;
import com.zhang.dinosaur.game.cs.event.EventObject;

public interface ConnectionSucceedEventListener extends EventListener{

    @Subscribe
    public void action(ConnectionSucceedEvent o);
}
