package com.zhang.dinosaur.config;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.common.EventBusUtil;
import com.zhang.dinosaur.event.AddCountEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ListenerConfig {
    public ListenerConfig() {
        EventBusUtil.register(this);
    }

    //cqrs command Query responsibility segregation
    @Subscribe
    public void addCount(AddCountEvent event){
        log.info("event come on");
        event.getCount().addAndGet(1);
    }
}
