package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainRightPanel extends JPanel {
    public MainRightPanel() {
        super(new MigLayout("flowy,fill","[grow,fill]","[grow,fill]"));
    }
}