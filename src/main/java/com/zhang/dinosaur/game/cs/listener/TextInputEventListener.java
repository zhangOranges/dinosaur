package com.zhang.dinosaur.game.cs.listener;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.cs.event.ShowTextAddContentEvent;

/**
 * jtext数据输入事件
 */
public interface TextInputEventListener  extends EventListener {

    public void textOut(ShowTextAddContentEvent text);
}
