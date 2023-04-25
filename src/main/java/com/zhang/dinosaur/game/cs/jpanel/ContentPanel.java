package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ContentPanel extends JPanel {
    public ContentPanel() {
        super(new MigLayout("", "[grow,fill]", "[grow,fill]"));
        //设置最左侧内边距,使左侧panel紧贴左侧边界
        this.setBorder( BorderFactory.createEmptyBorder(0,-13,0,0) );
    }
}
