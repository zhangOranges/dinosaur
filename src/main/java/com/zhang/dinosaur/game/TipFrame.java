package com.zhang.dinosaur.game;

import com.zhang.dinosaur.common.ThreadUtils;

import javax.swing.*;

/**
 * 提示界面
 */
public class TipFrame extends JFrame {
    public TipFrame(){
        super("TipFrame view");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);
        setLocationRelativeTo(null);
        ThreadUtils.sleep(2000);
        setVisible(true);
    }
}
