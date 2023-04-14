package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.compone.CsScrollBarUI;

import javax.swing.*;

import java.awt.*;

public class MainJScrollPane extends JScrollPane {
    private JPanel view;
    public MainJScrollPane(JPanel view) {
        super(view);
        this.view = view;
        setOpaque(false);
        getViewport().setOpaque(false);

        //scroll bar alpha
        getVerticalScrollBar().setOpaque(false);
        getHorizontalScrollBar().setOpaque(false);

        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        getVerticalScrollBar().setUI(new CsScrollBarUI());

        setBorder(BorderFactory.createEmptyBorder());

//        view.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                updateSize();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                updateSize();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                updateSize();
//            }
//
//            private void updateSize() {
//                view.revalidate();
//            }
//        });
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
