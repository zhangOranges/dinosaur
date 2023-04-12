package com.zhang.dinosaur.game.cs.jpanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class MainJScrollPane extends JScrollPane {
    private JTextPane view;
    public MainJScrollPane(JTextPane view) {
        super(view);
        this.view = view;
        setOpaque(false);
        getViewport().setOpaque(false);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        view.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSize();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSize();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSize();
            }

            private void updateSize() {
                view.revalidate();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        double LIMIT = 1 / 3d;
        int desired = (int) (view.getSize().height * LIMIT);
        int limit = Math.min(desired, d.height);
        return new Dimension(view.getWidth(), limit);
    }
}
