package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.compone.CsCaret;

import javax.swing.*;
import java.awt.*;

public class MainJTextPane extends JTextPane {
    public MainJTextPane() {
        CsCaret csCaret = new CsCaret();
        csCaret.setBlinkRate(500);
        setCaret(csCaret);
        setOpaque(false);
        setCaretColor(Color.GREEN);
        setForeground(Color.WHITE);
        setFont(new Font("", Font.PLAIN, 17));
    }
}
