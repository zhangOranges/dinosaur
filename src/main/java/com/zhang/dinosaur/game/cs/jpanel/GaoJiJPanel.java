package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GaoJiJPanel extends JPanel {
    public GaoJiJPanel() {
        super(new MigLayout("left,insets 20 30 0 0"));
        setBorder(BorderFactory.createTitledBorder("高级"));
        JLabel nocode = new JLabel("待开发");
        nocode.setForeground(Color.GRAY);
        add(nocode);
    }
}
