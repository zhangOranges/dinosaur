package com.zhang.dinosaur.common;

import cn.hutool.extra.spring.SpringUtil;
import com.google.common.eventbus.EventBus;
import com.zhang.dinosaur.WeatherListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *  event drive tools
 */
@Component
public class EventBusUtil {
    private static EventBus eventBus = new EventBus();
    private EventBusUtil(){
        String[] names = SpringUtil.getBeanNamesForType(WeatherListener.class);
        for (String name : names) {
            WeatherListener o = SpringUtil.getBean(name);
            eventBus.register(o);
        }
    }

    /**
     * register object
     * @param o
     */
    public void register(Object o){
        eventBus.register(o);
    }

    /**
     * post event
     * @param o
     */
    public void post(Object o){
        eventBus.post(o);
    }
}
