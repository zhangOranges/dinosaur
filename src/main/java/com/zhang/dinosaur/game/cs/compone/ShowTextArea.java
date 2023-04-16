package com.zhang.dinosaur.game.cs.compone;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.compone.CsCaret;
import com.zhang.dinosaur.game.cs.event.FocusEvent;
import com.zhang.dinosaur.game.cs.event.ShowTextAddContentEvent;
import com.zhang.dinosaur.game.cs.listener.TextInputEventListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ShowTextArea extends JTextArea implements TextInputEventListener {
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

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                GContextEventBus.post(new FocusEvent());
            }
        });
        GContextEventBus.register(this);

    }

    @Override
    public void textOut(ShowTextAddContentEvent e) {
        String text = e.getText();
        Document document = getDocument();
        try {
            int length = document.getLength();
            if (length != 0){
                text = "\n"+text;
            }
            document.insertString(length,text,null);
        } catch (BadLocationException badLocationException) {
            badLocationException.printStackTrace();
        }
    }

}
