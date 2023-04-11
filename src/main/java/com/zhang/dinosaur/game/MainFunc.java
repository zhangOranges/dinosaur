package com.zhang.dinosaur.game;

import lombok.SneakyThrows;

import javax.swing.*;

/**
 * 主启动类
 */
public class MainFunc {
    @SneakyThrows
    public static void main(String[] args) {
        //加载配置相关
        LoadingFrame loadingFrame = new LoadingFrame();
        SwingUtilities.invokeAndWait(()->{
            loadingFrame.loading();
        });
        SwingUtilities.invokeLater(()->{

            //加载主界面
            new MainFrame();
            //加载小提示
            if (GContext.isShowTip()) {
                new TipFrame("");
            }
        });
    }
}
