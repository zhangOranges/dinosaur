package com.zhang.dinosaur.game.cs.jframe;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * 提示界面
 */
public class TipFrame extends JFrame {

    public TipFrame(String msg){
        super("Tip");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);

        JPanel jPanel = new JPanel(new MigLayout("align 50% 50%"));
        jPanel.add(new JLabel(msg));
        add(jPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public TipFrame(JPanel jPanel){
        super("Tip");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);
        add(jPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
