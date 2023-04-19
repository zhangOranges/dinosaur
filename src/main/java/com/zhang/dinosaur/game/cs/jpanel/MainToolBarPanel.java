package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.compone.MainToolBarTextArea;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

public class MainToolBarPanel extends JPanel {

    public MainToolBarPanel() {
        super(new MigLayout("insets 0 0 0 0","[grow 80,fill]-1[grow 20,fill]","grow,fill"));
        setOpaque(false);


        JScrollPane jScrollPane = new RoundedJScrollPane(new MainToolBarTextArea());
        jScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);

        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setOpaque(false);


        add(jScrollPane);


        add(new MainToolBarJButtonPanel());


    }
}
