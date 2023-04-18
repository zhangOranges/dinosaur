package com.zhang.dinosaur.game.common;

public class ThreadUtils {
    public static boolean sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }
}
