package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ChangGuiJPanel extends JPanel {
    public ChangGuiJPanel() {
        super(new MigLayout("left,insets 20 30 0 0"));
        //文本框的最小宽度
        String textMWidth = "wmin 200";
        setBorder(BorderFactory.createTitledBorder("常规"));
        JLabel name = new JLabel("名称");
        JTextField value = new JTextField();
        add(name);
        add(value,"wrap,"+textMWidth);
        name = new JLabel("主机");
        value = new JTextField();
        add(name);
        add(value,textMWidth);
        name = new JLabel("端口");
        value = new JTextField();
        add(name);
        add(value,"wrap,wmin 50");

        name = new JLabel("备注");

        JTextArea textArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(textArea);
        add(name);
        add(jScrollPane,"w 200,h 50");

    }
}
