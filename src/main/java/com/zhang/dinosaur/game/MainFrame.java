package com.zhang.dinosaur.game;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 主界面
 */
public class MainFrame extends JFrame {

    public MainFrame(){
        super("MainFrame view");
        {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setSize(1000, 750);
            setLocationRelativeTo(null);
        }
        JPanel mainPanel = new JPanel(new MigLayout("insets 30,wrap 10"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        {
            for (int i = 0; i < 15; i++) {
                JLabel hello = new JLabel("hello"+i);
                hello.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                mainPanel.add(hello);
            }

        }
        setContentPane(mainPanel);

        setVisible(true);
    }
}
