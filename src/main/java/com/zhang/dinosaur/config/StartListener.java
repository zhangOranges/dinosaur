package com.zhang.dinosaur.config;

import com.zhang.dinosaur.domain.Earth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartListener implements ApplicationRunner {
    @Autowired
    private Earth env;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        env.init();
        env.doSomeThing();
        env.destroy();
    }
}
