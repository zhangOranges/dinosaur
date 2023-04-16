package com.zhang.dinosaur.game.cs.compone;


import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JTextFieldHint extends JTextField implements FocusListener {
    private String hint;

    public JTextFieldHint(String hint) {
        this.hint = hint;
        setForeground(Color.GRAY);
        setText(hint);
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(hint)) {
            setText("");
            setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().equals("")) {
            setForeground(Color.GRAY);
            setText(hint);
        }
    }
}
