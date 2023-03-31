package com.zhang.dinosaur.controller;

import com.zhang.dinosaur.common.EventBusUtil;
import com.zhang.dinosaur.common.RedisUtilPro;
import com.zhang.dinosaur.config.TestConfig;
import com.zhang.dinosaur.event.WindEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.GenericScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping
@Slf4j
public class DinosaurController implements ApplicationListener<RefreshScopeRefreshedEvent> {


    @Autowired
    private RedisUtilPro redisUtilPro;

    @Autowired
    private EventBusUtil eventBusUtil;
    private String[] hello = {"你好","hello","مرحبا","Witam","Здравейте","Hallo",""};

    private AtomicLong count = new AtomicLong(0);

    private AtomicBoolean aBoolean = new AtomicBoolean(false);
    @Autowired
    private TestConfig testConfig;

    /**
     * index hello
     * @return
     */
    @GetMapping("index")
    public String index(){
        return "welcome Dinosaur index";
    }

    @GetMapping("sayAnyHello")
    public String sayAnyHello(){
        count.getAndAdd(1);
        int i = count.intValue() % hello.length;
        return hello[i];
    }

    /**
     * play wind
     * @return
     */
    @GetMapping("wind")
    public String wind(){
        eventBusUtil.post(new WindEvent());
        return "wind ok";
    }

    /**
     * 返回thread id
     * @return
     */
    @GetMapping("threadId")
    public String threadId(){

        return Thread.currentThread().getId()+"";
    }

    @GetMapping("getEnv")
    public String getEnv(){
        boolean b = aBoolean.get();
        if (b){
            RequestContextHolder.currentRequestAttributes().setAttribute(GenericScope.SCOPED_TARGET_PREFIX+"testConfig",null, RequestAttributes.SCOPE_SESSION);
            aBoolean.compareAndSet(true,false);
        }
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(TestConfig.class).getPropertyDescriptors();
            for (PropertyDescriptor pd : propertyDescriptors) {
                Class<?> propertyType = pd.getPropertyType();
                if (!propertyType.getName().equals(String.class.getName())){
                    continue;
                }
                Method method = pd.getWriteMethod();
                if (method!=null)
                System.out.println(method.getName());
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return "0k";
    }

    @Override
    public void onApplicationEvent(RefreshScopeRefreshedEvent event) {
        aBoolean.compareAndSet(false,true);
    }




    @GetMapping("redisTest")
    public void redisTest(){

        Boolean one = redisUtilPro.lock("one");
        try {
            Thread.sleep(31000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(one);
        redisUtilPro.unlock("one");

    }








}
