package com.zhang.dinosaur.game;

import javax.swing.*;

/**
 * 主启动类
 */
public class MainFunc {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //加载配置相关
            new LoadingFrame();
            //加载主界面
            new MainFrame();
            //加载小提示
            if (GContext.isShowTip()) {
                new TipFrame();
            }
        });
    }
}
