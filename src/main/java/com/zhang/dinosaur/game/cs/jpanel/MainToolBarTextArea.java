package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.listen.TextAreaToJTextPanelKeyAdapter;

import javax.swing.*;
import java.awt.*;

public class MainToolBarTextArea extends JTextArea {
    public MainToolBarTextArea() {
        setLineWrap(false);
        setWrapStyleWord(false);
        setOpaque(false);
        setCaretColor(Color.green);
        setForeground(Color.WHITE);
        setFont(new Font("", Font.PLAIN, 20));
        addKeyListener(new TextAreaToJTextPanelKeyAdapter(this));
    }
}
