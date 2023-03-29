package com.zhang.dinosaur.config;

import com.zhang.dinosaur.domain.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Configuration(proxyBeanMethods = false)
//@RefreshScope
public class TestConfig implements EnvironmentAware {

    private Environment environment;
    private String name;

    @Autowired
    private List<Animal> animalList = new ArrayList<>();

    public String getName() {
        return name;
    }
    @Value("${names:zhang}")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }
    public List<Animal> getAnimalList() {
        return animalList;
    }
}
