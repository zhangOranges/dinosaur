package com.zhang.dinosaur.common;

import cn.hutool.extra.spring.SpringUtil;
import com.google.common.eventbus.EventBus;
import com.zhang.dinosaur.WeatherListener;
import com.zhang.dinosaur.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *  event drive tools
 */
@Component
public class EventBusUtil {
    private static EventBus eventBus = new EventBus();
    private EventBusUtil(){
        Map<String, EventListener> beansOfType = SpringUtil.getBeansOfType(EventListener.class);
        beansOfType.entrySet().forEach(event->eventBus.register(event));
    }

    /**
     * post event
     * @param o
     */
    public void post(Object o){
        eventBus.post(o);
    }
}
