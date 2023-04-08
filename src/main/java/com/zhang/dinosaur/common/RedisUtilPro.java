//package com.zhang.dinosaur.common;
//
//import cn.hutool.core.thread.NamedThreadFactory;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//
//import javax.annotation.Resource;
//import java.time.LocalDateTime;
//import java.util.Map;
//import java.util.concurrent.*;
//
//@Configuration
//@Slf4j
//public class RedisUtilPro {
//    /**
//     * redis ttl time 和 renew time
//     */
//    private long timeout = 10;
//    private  static ScheduledExecutorService watchDog = Executors.newScheduledThreadPool(8, new NamedThreadFactory("watchDog", false));
//    private static Map<Object,ScheduledFuture> map = new ConcurrentHashMap<>();
////    @Resource(name = "stringRedisTemplate")
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    public Boolean setIfAbsent(Object key, Object value, long timeout, TimeUnit unit){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        return valueOperations.setIfAbsent(key,value,timeout,unit);
//    }
//
//    public Object get(Object key){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        return valueOperations.get(key);
//    }
//
//    public long ttl(Object key){
//        return redisTemplate.getExpire(key);
//    }
//
//    public Boolean setExpire(Object key,long timeout){
//        return redisTemplate.expire(key,timeout,TimeUnit.SECONDS);
//    }
//
//    public Boolean del(Object key){
//        if (get(key) == null){
//            return true;
//        }
//        return redisTemplate.delete(key);
//    }
//
//    public Boolean lock(Object key){
//        Boolean flag = setIfAbsent(key, LocalDateTime.now().toString(),timeout,TimeUnit.SECONDS);
//        if (!flag){
//            log.debug("lock is other used!");
//            return flag;
//        }
//        log.debug("添加watchdog key = {}",key);
//        ScheduledFuture<?> scheduledFuture = watchDog.scheduleAtFixedRate(new WatchDog( this, key), timeout-1, timeout, TimeUnit.SECONDS);
//        map.put(key,scheduledFuture);
//        return flag;
//    }
//    public void unlock(Object key) {
//        log.debug("unlock key = {}",key);
//        ScheduledFuture scheduledFuture = map.get(key);
//        if (scheduledFuture != null ){
//            log.debug("强制取消watchdog key = {}",key);
//            scheduledFuture.cancel(true);
//            map.remove(key);
//        }
//        del(key);
//    }
//    @Slf4j
//    static class WatchDog implements Runnable{
//
//        private Thread thread;
//        private RedisUtilPro redisUtilPro;
//        private Object key;
//
//        public WatchDog(RedisUtilPro redisUtilPro, Object key) {
//            this.redisUtilPro = redisUtilPro;
//            this.key = key;
//        }
//
//        @Override
//        public void run() {
//            log.debug("watch dog time = {}", LocalDateTime.now().toString());
//            Object o = redisUtilPro.get(key);
//            if (o == null){
//                log.debug("thread no hold lock del");
//                redisUtilPro.del(key);
//            }else{
//                log.debug("thread have hold lock expire");
//                redisUtilPro.setExpire(key,30);
//            }
//            log.debug("watch dog done");
//        }
//    }
//}
