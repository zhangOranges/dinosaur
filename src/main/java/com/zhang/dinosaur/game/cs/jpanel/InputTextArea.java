package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.compone.CsCaret;
import com.zhang.dinosaur.game.cs.listen.TextAreaToJTextPanelKeyAdapter;

import javax.swing.*;
import java.awt.*;

public class InputTextArea extends JTextArea {
    private JTextArea out;
    public InputTextArea(JTextArea out) {
        super();

        this.out = out;
        setLineWrap(true);
        setWrapStyleWord(true);
        CsCaret csCaret = new CsCaret();
        csCaret.setBlinkRate(500);
        setCaret(csCaret);
        setOpaque(false);
        setCaretColor(Color.GREEN);
        setForeground(Color.WHITE);
        setFont(new Font("", Font.PLAIN, 17));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        addKeyListener(new TextAreaToJTextPanelKeyAdapter(this,out));

        setBorder(BorderFactory.createLineBorder(Color.cyan));
    }
}
