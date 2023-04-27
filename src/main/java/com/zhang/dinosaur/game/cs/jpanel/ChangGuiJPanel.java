package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ChangGuiJPanel extends JPanel {
    public ChangGuiJPanel() {
        super(new MigLayout("left,insets 20 30 0 0"));
        setBorder(BorderFactory.createTitledBorder("常规"));
        JLabel name = new JLabel("名称");
        JTextField value = new JTextField();
        add(name);
        add(value,"wrap");
        name = new JLabel("主机");
        value = new JTextField();
        add(name);
        add(value);
        name = new JLabel("端口");
        value = new JTextField();
        add(name);
        add(value,"wrap");

        name = new JLabel("备注");
        value = new JTextField();
        add(name);
        add(value,"w 200,h 50");

    }
}
