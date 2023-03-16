package com.zhang.dinosaur.common;

import com.google.common.eventbus.EventBus;

/**
 * 事件驱动工具类
 */
public class EventBusUtil {
    private static EventBus eventBus = new EventBus();
    private void EventUtil(){}

    /**
     * 注册对象
     * @param o
     */
    public static void register(Object o){
        eventBus.register(o);
    }

    /**
     * 发送事件
     * @param o
     */
    public static void post(Object o){
        eventBus.post(o);
    }
}
