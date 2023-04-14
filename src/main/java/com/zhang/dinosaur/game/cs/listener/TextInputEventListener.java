package com.zhang.dinosaur.game.cs.listener;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.cs.event.ShowTextAddContentEvent;


public interface TextInputEventListener  extends EventListener {

    @Subscribe
    public void textOut(ShowTextAddContentEvent text);
}
