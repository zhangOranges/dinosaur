package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ConnectJPanel extends JPanel {
    public ConnectJPanel() {
        super(new MigLayout("insets 0,wrap","grow,fill","[grow 99,fill]0[grow 1,fill]"));
    }
}
