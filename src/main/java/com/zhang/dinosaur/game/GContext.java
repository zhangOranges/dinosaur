package com.zhang.dinosaur.game;

import com.zhang.dinosaur.common.ThreadUtils;

/**
 * 全局的上下文
 */

public class GContext {

    private GContext(){}
    private static boolean showTip = false;
    public static void setShowTip(boolean showTip) {
        GContext.showTip = showTip;
    }

    public static boolean isShowTip() {
        return showTip;
    }


    public static void loadConfig(){
        ThreadUtils.sleep(2000);
    }
}
