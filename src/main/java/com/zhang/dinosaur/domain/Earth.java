package com.zhang.dinosaur.domain;

import cn.hutool.core.thread.NamedThreadFactory;
import cn.hutool.extra.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class Earth extends Env{
    private List<Animal> animals = new ArrayList<>();
    @Override
    public void init() {

        String[] names = SpringUtil.getBeanNamesForType(Animal.class);
        for (String name : names) {
            Animal animal = SpringUtil.getBean(name);
            animals.add(animal.born());
        }
    }

    @Override
    public void doSomeThing() {
        for (;;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            animals.forEach(Animal::action);
        }
    }

    @Override
    public void destroy() {
        animals.forEach(Animal::death);
    }
}
