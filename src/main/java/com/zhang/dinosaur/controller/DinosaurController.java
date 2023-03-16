package com.zhang.dinosaur.controller;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.common.EventBusUtil;
import com.zhang.dinosaur.event.AddCountEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping
@Slf4j
public class DinosaurController {

    public DinosaurController() {
        EventBusUtil.register(this);
    }

    private String[] hello = {"你好","hello","مرحبا","Witam","Здравейте","Hallo",""};


    private AtomicLong count = new AtomicLong(0);


    /**
     * 首页 欢迎语
     * @return
     */
    @GetMapping("index")
    public String index(){
        return "welcome Dinosaur index";
    }

    @GetMapping("sayAnyHello")
    public String sayAnyHello(){
        log.info("post event");
        EventBusUtil.post(new AddCountEvent());
        int i = count.intValue() % hello.length;
        return hello[i];
    }

    //cqrs
    @Subscribe
    public void addCount(AddCountEvent event){
        log.info("event come on");
        count.addAndGet(1);
    }
}
