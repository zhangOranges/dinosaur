package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.button.CsJButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainToolBarJButtonPanel extends JPanel {
    public MainToolBarJButtonPanel() {
        super(new MigLayout("insets 0 10 0 0"));
        setBackground(new Color(0,0,0,100));
//        setOpaque(false);
        JButton history = new CsJButton("历史");
        JButton options = new CsJButton("选项");

        add(history,"wmin 40");
        add(options,"wmin 40");

    }
}
