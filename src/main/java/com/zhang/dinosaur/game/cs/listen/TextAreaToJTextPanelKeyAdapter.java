package com.zhang.dinosaur.game.cs.listen;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextAreaToJTextPanelKeyAdapter extends KeyAdapter {
    private JTextArea jTextArea;
    private JTextArea view;

    public TextAreaToJTextPanelKeyAdapter(JTextArea jTextArea,JTextArea view) {
        this.jTextArea = jTextArea;
        this.view = view;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //impl wrap   next time impl interaction
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = jTextArea.getText().replaceAll("\\n", "").trim();
            {
                Document document = view.getDocument();

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
            jTextArea.setText("");
            jTextArea.setCaretPosition(0);
        }else{
            super.keyPressed(e);
        }
    }
}
