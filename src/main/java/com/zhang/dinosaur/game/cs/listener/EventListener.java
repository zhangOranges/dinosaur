package com.zhang.dinosaur.game.cs.listener;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.cs.event.EventObject;

/**
 * 事件监听 顶级接口
 */
public interface EventListener {
    @Subscribe
    default void action(EventObject o){}
}
