package com.zhang.dinosaur.game.cs.compone;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.compone.CsCaret;
import com.zhang.dinosaur.game.cs.event.FocusEvent;
import com.zhang.dinosaur.game.cs.dapter.TextAreaToJTextPanelKeyAdapter;
import com.zhang.dinosaur.game.cs.listener.FocusEventListener;

import javax.swing.*;
import javax.swing.text.Caret;
import java.awt.*;

public class InputTextArea extends JTextArea implements FocusEventListener{

    public InputTextArea() {
        super();

        setLineWrap(true);
        setWrapStyleWord(true);
        Caret csCaret = new CsCaret();
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
        Insets margin = getMargin();
        margin.set(-2,margin.left,margin.bottom,margin.right);
        setMargin(margin);
    }


    @Override
    @Subscribe
    public void action(FocusEvent e) {
        grabFocus();
    }
}
