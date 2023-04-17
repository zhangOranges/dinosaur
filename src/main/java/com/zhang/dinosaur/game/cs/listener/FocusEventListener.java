package com.zhang.dinosaur.game.cs.listener;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.cs.event.FocusEvent;

/**
 * 聚焦事件监听接口
 */
public interface FocusEventListener extends EventListener{
    public void action(FocusEvent e);
}
