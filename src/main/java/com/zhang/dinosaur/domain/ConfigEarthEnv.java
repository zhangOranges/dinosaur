package com.zhang.dinosaur.domain;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@Component
public class ConfigEarthEnv extends Earth{

    @Override
    public void doSomeThing() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("ConfigEarthEnv");
                t.setDaemon(true);
                return t;
            }
        });

           executor.scheduleWithFixedDelay(()->{
               super.doSomeThing();
           },1,1, TimeUnit.SECONDS);

    }

    @Override
    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
