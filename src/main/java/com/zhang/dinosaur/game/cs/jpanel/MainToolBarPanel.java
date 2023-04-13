package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainToolBarPanel extends JPanel {
    public MainToolBarPanel() {
        //todo   add bar
        super(new MigLayout("insets 5 5 5 5","[grow 40,fill][grow 60,fill]",""));
        setBorder(BorderFactory.createLineBorder(Color.cyan));
        JTextArea jTextArea = new JTextArea();
        jTextArea.setLineWrap(false);
        jTextArea.setWrapStyleWord(false);
        jTextArea.setBackground(Color.MAGENTA);
        add(jTextArea);
        JLabel hello = new JLabel("hello");
        hello.setBackground(Color.BLACK);
        add(hello);
    }
}
