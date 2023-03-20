package com.zhang.dinosaur.common;

import com.google.common.eventbus.EventBus;

/**
 * 事件驱动工具类 event drive tools
 */
public class EventBusUtil {
    private static EventBus eventBus = new EventBus();
    private void EventUtil(){}

    /**
     * register object
     * @param o
     */
    public static void register(Object o){
        eventBus.register(o);
    }

    /**
     * post event
     * @param o
     */
    public static void post(Object o){
        eventBus.post(o);
    }
}
