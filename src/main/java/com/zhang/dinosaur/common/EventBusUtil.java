package com.zhang.dinosaur.common;

import cn.hutool.extra.spring.SpringUtil;
import com.google.common.eventbus.EventBus;
import com.zhang.dinosaur.WeatherListener;
import com.zhang.dinosaur.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *  event drive tools
 */
@Component
public class EventBusUtil {
    private static EventBus eventBus = new EventBus();
    private EventBusUtil(){
        String[] names = SpringUtil.getBeanNamesForType(EventListener.class);
        for (String name : names) {
            EventListener o = SpringUtil.getBean(name);
            eventBus.register(o);
        }
    }

    /**
     * post event
     * @param o
     */
    public void post(Object o){
        eventBus.post(o);
    }
}
