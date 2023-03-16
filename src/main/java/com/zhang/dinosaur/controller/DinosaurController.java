package com.zhang.dinosaur.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping
public class DinosaurController {

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
    public String sayAny(){
        count.addAndGet(1);
        int i = count.intValue() % hello.length;
        return hello[i];
    }
}
