package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.compone.CsCaret;

import javax.swing.*;
import java.awt.*;

public class ShowTextArea extends JTextArea {
    public ShowTextArea() {
        super();
        setFocusable(false);
        setLineWrap(true);
        setEditable(false);
        setOpaque(false);
        CsCaret csCaret = new CsCaret();
        csCaret.setBlinkRate(500);
        setCaret(csCaret);
        setCaretColor(Color.GREEN);
        setForeground(Color.WHITE);
        setFont(new Font("", Font.PLAIN, 17));


        setBorder(BorderFactory.createLineBorder(Color.cyan));

    }
}
