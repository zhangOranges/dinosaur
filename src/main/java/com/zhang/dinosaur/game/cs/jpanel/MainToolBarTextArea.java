package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.dapter.TextAreaToJTextPanelKeyAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MainToolBarTextArea extends JTextArea {
    public MainToolBarTextArea() {
        setLineWrap(false);
        setWrapStyleWord(false);
        setOpaque(false);
        setCaretColor(Color.green);
        setForeground(Color.WHITE);
        setFont(new Font("", Font.PLAIN, 20));
        addKeyListener(new TextAreaToJTextPanelKeyAdapter(this));
        getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "tab");
        getActionMap().put("tab", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("press tab");
            }
        });
    }
}
