package com.zhang.dinosaur.game.cs.compone;

import com.zhang.dinosaur.game.cs.dapter.TextAreaToJTextPanelKeyAdapter;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
@Slf4j
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
                log.debug("press tab");
            }
        });
    }
}
