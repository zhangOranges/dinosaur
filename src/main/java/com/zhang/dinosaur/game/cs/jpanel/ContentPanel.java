package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ContentPanel extends JPanel {
    public ContentPanel() {
        super(new MigLayout("", "[grow,fill]", "[grow,fill]"));
    }
}
