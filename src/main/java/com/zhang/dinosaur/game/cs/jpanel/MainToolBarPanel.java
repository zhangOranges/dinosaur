package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Utilities;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

public class MainToolBarPanel extends JPanel {
    private JTextPane view;
    public MainToolBarPanel(JTextPane view) {
        //todo   add bar
        super(new MigLayout("insets 10 10 -20 0","[grow 80,fill][grow 20,fill]",""));
        this.view = view;
        setOpaque(false);


        JTextArea jTextArea = new JTextArea();
        jTextArea.setLineWrap(false);
        jTextArea.setWrapStyleWord(false);
        jTextArea.setOpaque(false);
        jTextArea.setCaretColor(Color.green);
        jTextArea.setForeground(Color.WHITE);
        jTextArea.setFont(new Font("", Font.PLAIN, 20));


        JScrollPane jScrollPane = new RoundedJScrollPane(jTextArea);
        jScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        jScrollPane.setBackground(new Color(0,0,0,150));

        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setOpaque(false);


        add(jScrollPane);

        //func button
        Button button = new Button("b1");
        jTextArea.addKeyListener(new KeyAdapter() {
            private int i = 0;
            @Override
            public void keyPressed(KeyEvent e) {
                //impl wrap   next time impl interaction
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String text = jTextArea.getText().replaceAll("\\n", "").trim();
                    {
                        Document document = view.getDocument();
                        try {
                            document.insertString(document.getLength(),text+"\n",null);
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
        });

        add(button);
    }

    public int getRow(){
        int caretPosition = view.getCaretPosition();
        int row = (caretPosition == 0) ? 1 : 0;
        for (int offset = caretPosition; offset > 0;) {
            try {
                offset = Utilities.getRowStart(view, offset) - 1;
            } catch (BadLocationException badLocationException) {
                break;
            }
            row++;
        }

        return  row;
    }
}
