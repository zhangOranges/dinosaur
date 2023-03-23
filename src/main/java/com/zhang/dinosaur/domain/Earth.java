package com.zhang.dinosaur.domain;

import cn.hutool.core.thread.NamedThreadFactory;
import cn.hutool.extra.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Earth extends Env{
    private List<Animal> animals = new ArrayList<>();
    public void init() {

        String[] names = SpringUtil.getBeanNamesForType(Animal.class);
        for (String name : names) {
            Animal animal = SpringUtil.getBean(name);
            animals.add(animal.born());
        }
    }

    public void doSomeThing() {
        animals.forEach(e->{
            e.action(this);
        });
    }

    public void destroy() {
        animals.forEach(Animal::death);
    }

    @Override
    public LocalDateTime getNow() {
        return null;
    }
}
