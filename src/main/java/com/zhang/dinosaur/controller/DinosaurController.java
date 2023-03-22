package com.zhang.dinosaur.controller;

import com.zhang.dinosaur.common.EventBusUtil;
import com.zhang.dinosaur.event.WeatherEvent;
import com.zhang.dinosaur.event.WindEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping
@Slf4j
public class DinosaurController {


    @Autowired
    private EventBusUtil eventBusUtil;
    private String[] hello = {"你好","hello","مرحبا","Witam","Здравейте","Hallo",""};

    private AtomicLong count = new AtomicLong(0);


    /**
     * index hello
     * @return
     */
    @GetMapping("index")
    public String index(){
        return "welcome Dinosaur index";
    }

    @GetMapping("sayAnyHello")
    public String sayAnyHello(){
        count.getAndAdd(1);
        int i = count.intValue() % hello.length;
        return hello[i];
    }

    /**
     * play wind
     * @return
     */
    @GetMapping("wind")
    public String wind(){
        eventBusUtil.post(new WindEvent());
        return "wind ok";
    }
}
