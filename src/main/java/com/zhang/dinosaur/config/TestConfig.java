package com.zhang.dinosaur.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class TestConfig {

    private int port;

    public int getPort() {
        return port;
    }

    @Value("${server.port:8888}")
    public void setPort(int port) {
        this.port = port;
    }
}
