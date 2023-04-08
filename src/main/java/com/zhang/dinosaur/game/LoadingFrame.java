package com.zhang.dinosaur.game;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * 加载界面
 */

public class LoadingFrame extends JFrame {
    private JPanel panel = new JPanel(new MigLayout("align c c"));
    public LoadingFrame(){
        super("loading view");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        panel.add(new JLabel("loading"));
        setContentPane(panel);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);


        {
            //后期处理这里加载配置信息
            GContext.loadConfig();
        }



        setVisible(false);
    }
}
