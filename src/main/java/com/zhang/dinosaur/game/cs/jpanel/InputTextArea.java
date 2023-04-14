package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.compone.CsCaret;
import com.zhang.dinosaur.game.cs.event.EventObject;
import com.zhang.dinosaur.game.cs.event.FocusEvent;
import com.zhang.dinosaur.game.cs.listen.TextAreaToJTextPanelKeyAdapter;
import com.zhang.dinosaur.game.cs.listener.FocusEventListener;

import javax.swing.*;
import java.awt.*;

public class InputTextArea extends JTextArea implements FocusEventListener{

    public InputTextArea() {
        super();

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
        addKeyListener(new TextAreaToJTextPanelKeyAdapter(this));
        grabFocus();


        GContextEventBus.register(this);
    }


    @Override
    public void action(FocusEvent e) {
        grabFocus();
    }
}
