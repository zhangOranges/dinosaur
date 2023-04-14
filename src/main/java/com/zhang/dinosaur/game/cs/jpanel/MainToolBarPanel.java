package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.listen.TextAreaToJTextPanelKeyAdapter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

public class MainToolBarPanel extends JPanel {

    public MainToolBarPanel() {
        super(new MigLayout("insets 10 10 -20 0","[grow 80,fill][grow 20,fill]",""));
        setOpaque(false);


        JScrollPane jScrollPane = new RoundedJScrollPane(new MainToolBarTextArea());
        jScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        jScrollPane.setBackground(new Color(0,0,0,150));

        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setOpaque(false);


        add(jScrollPane);

        //func button ...
        Button button = new Button("b1");

        add(button);
    }
}
