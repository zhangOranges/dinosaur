package com.zhang.dinosaur.common;

import cn.hutool.extra.spring.SpringUtil;
import com.google.common.eventbus.EventBus;
import com.zhang.dinosaur.listener.EnvEventListener;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 *  event drive tools
 */
@Configuration
public class EventBusUtil {
    private static EventBus eventBus = new EventBus();
    private EventBusUtil(){
        Map<String, EnvEventListener> beansOfType = SpringUtil.getBeansOfType(EnvEventListener.class);
        beansOfType.values().forEach(event->eventBus.register(event));
    }

    /**
     * post event
     * @param o
     */
    public void post(Object o){
        eventBus.post(o);
    }
}
