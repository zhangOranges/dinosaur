package com.zhang.dinosaur.config;

import com.zhang.dinosaur.domain.Animal;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Configuration(proxyBeanMethods = false)
@SessionScope
public class TestConfig {

    private String name;


    public String getName() {
        return name;
    }
    @Value("${names:zhang}")
    public void setName(String name) {
        this.name = name;
    }

}
