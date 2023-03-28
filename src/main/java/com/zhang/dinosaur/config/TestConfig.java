package com.zhang.dinosaur.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
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
