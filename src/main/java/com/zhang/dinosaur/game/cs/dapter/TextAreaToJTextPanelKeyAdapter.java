package com.zhang.dinosaur.game.cs.dapter;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.event.ShowTextAddContentEvent;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextAreaToJTextPanelKeyAdapter extends KeyAdapter {
    private JTextArea jTextArea;

    public TextAreaToJTextPanelKeyAdapter(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //impl wrap   next time impl interaction
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = jTextArea.getText();
            {
                GContextEventBus.post(new ShowTextAddContentEvent(text,(s)->s.replaceAll("\\n", "").trim()));
            }
            jTextArea.setText("");
            jTextArea.setCaretPosition(0);
        }else{
            super.keyPressed(e);
        }
    }
}
