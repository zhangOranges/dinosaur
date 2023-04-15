package com.zhang.dinosaur.game.cs.listener;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.cs.event.TreeClickedEvent;

public interface TreeClickedListener extends EventListener{
    @Subscribe
    public void action( TreeClickedEvent e);
}
