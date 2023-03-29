package com.zhang.dinosaur.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@RefreshScope
public class TestConfig implements EnvironmentAware {

    private Environment environment;
    private String name;

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
}
