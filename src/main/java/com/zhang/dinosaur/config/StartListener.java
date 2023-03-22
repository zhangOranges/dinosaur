package com.zhang.dinosaur.config;

import com.zhang.dinosaur.domain.ConfigEarthEnv;
import com.zhang.dinosaur.domain.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartListener implements ApplicationRunner {
    @Autowired
    private Env env;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        env.init();
        env.doSomeThing();
        env.destroy();
    }
}
