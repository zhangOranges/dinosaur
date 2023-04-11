package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 左侧面板
 */
public class MainLeftPanel extends JPanel {
    public MainLeftPanel() {
        super(new MigLayout("flowx,,wrap","[grow,fill]",""));
    }
}
