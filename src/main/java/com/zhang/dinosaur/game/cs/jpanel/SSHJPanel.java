package com.zhang.dinosaur.game.cs.jpanel;


import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SSHJPanel extends JPanel {
    public SSHJPanel() {
        super(new MigLayout("wrap","grow,fill","grow,fill"));
        {
            JPanel changgui = new ChangGuiJPanel();
            add(changgui);
            JPanel renzheng = new RenZhengJPanel();
            add(renzheng);
            JPanel gaoji = new GaoJiJPanel();
            add(gaoji);
        }
    }
}
