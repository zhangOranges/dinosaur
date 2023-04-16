package com.zhang.dinosaur.game.cs.jpanel;

import javax.swing.*;

/**
 * 整理代码
 */
public class ContentTabbedPane extends JTabbedPane {

    public ContentTabbedPane(JPanel mainLeftPanel, JPanel mainRightPanel) {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, mainLeftPanel, mainRightPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);
        splitPane.setDividerSize(1);
        splitPane.setDividerLocation(150);
        splitPane.setOpaque(false);
        splitPane.setBorder(null);
        addTab("基本信息",splitPane);
    }
}
