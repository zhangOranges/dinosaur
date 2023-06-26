package com.zhang.dinosaur.game;

import com.formdev.flatlaf.FlatLightLaf;
import com.zhang.dinosaur.game.context.GContext;
import com.zhang.dinosaur.game.cs.jframe.LoadingFrame;
import com.zhang.dinosaur.game.cs.jframe.MainFrame;
import com.zhang.dinosaur.game.cs.jframe.TipFrame;
import lombok.SneakyThrows;

import javax.swing.*;

/**
 * 主启动类 dev_cp
 */
public class MainFunc {
    @SneakyThrows
    public static void main(String[] args) {

//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        UIManager.setLookAndFeel(new FlatLightLaf());

        //加载配置相关
        LoadingFrame loadingFrame = new LoadingFrame();
        SwingUtilities.invokeAndWait(loadingFrame::loading);
        SwingUtilities.invokeLater(()->{

            //加载主界面
            new MainFrame().pack();
            //加载小提示
            if (GContext.isShowTip()) {
                new TipFrame("");
            }
        });
    }
}
