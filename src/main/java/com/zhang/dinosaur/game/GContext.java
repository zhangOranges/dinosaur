package com.zhang.dinosaur.game;

import com.zhang.dinosaur.common.ThreadUtils;

/**
 * 全局的上下文
 */

public class GContext {

    public static final String _prefix_title = "标签页";
    public static final String _default_title = "标签页 1";

    private GContext(){}
    private static boolean showTip = false;
    public static void setShowTip(boolean showTip) {
        GContext.showTip = showTip;
    }

    public static boolean isShowTip() {
        return showTip;
    }


    public static void loadConfig(){
        ThreadUtils.sleep(100);
    }

    /**
     * get host info
     * @return
     */
    public static Object[][] getHostInfo(){

        return null;
    }
}
