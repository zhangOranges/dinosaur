package com.zhang.dinosaur.config;

import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicLong;

@Configuration(proxyBeanMethods = false)
public class TestConfig {

    AtomicLong atomicLong = new AtomicLong(0);

//    @Cacheable
    public String getName() {
        return atomicLong.addAndGet(1)+"";
    }

}
