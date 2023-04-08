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

            //加载
            LoadingFrame loadingFrame = new LoadingFrame();
            loadingFrame.setVisible(false);

            MainFrame mainFrame = new MainFrame();
            new TipFrame();




        });
    }
}
