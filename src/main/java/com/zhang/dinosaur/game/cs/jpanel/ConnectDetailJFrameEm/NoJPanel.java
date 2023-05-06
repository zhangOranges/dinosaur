package com.zhang.dinosaur.game.cs.jpanel.ConnectDetailJFrameEm;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class NoJPanel extends JPanel {
    public NoJPanel() {
        super(new MigLayout());
        add(new JLabel("暂无内容"));
    }
}
