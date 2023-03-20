package com.zhang.dinosaur.controller;

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
        log.info("post event");
        EventBusUtil.post(new AddCountEvent(count));
        int i = count.intValue() % hello.length;
        return hello[i];
    }


}
