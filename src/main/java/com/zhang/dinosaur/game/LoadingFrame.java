package com.zhang.dinosaur.game;

import com.zhang.dinosaur.common.ThreadUtils;
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

        ThreadUtils.sleep(2000);
    }
}
