package com.zhang.dinosaur.game;

import javax.swing.*;

/**
 * 主界面
 */
public class MainFrame extends JFrame {

    public MainFrame(){
        super("MainFrame view");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000, 750);
        setLocationRelativeTo(null);

        setVisible(true);
    }
}
