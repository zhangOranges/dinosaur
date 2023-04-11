package com.zhang.dinosaur.game.cs.jpanel;

import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 默认panel
 */
@Slf4j
public class DefaultPanel extends JPanel {
    private JTabbedPane jTabbedPane;
    private String title;
    public DefaultPanel() {
        super(new MigLayout("wrap","[grow,fill]",""));
        JPanel jPanel = new JPanel(new MigLayout(""));
        jPanel.setBackground(Color.LIGHT_GRAY);
        jPanel.setPreferredSize(new Dimension(this.getWidth(),30));
        add(jPanel);
        JButton connect = new JButton("connect");
        add(connect);
        connect.addActionListener((e)->{
            int i = jTabbedPane.indexOfTab(title);
            JPanel mainRightPanel = new JPanel(new MigLayout("wrap,fill","[grow,fill]","[grow 75,fill]0[grow 25,fill]"));
            mainRightPanel.add(new MainPanel());
            mainRightPanel.add(new JTabbedPane());
            jTabbedPane.setComponentAt(i,mainRightPanel);
        });
    }

    public void setPanel(JTabbedPane jTabbedPane) {
        this.jTabbedPane = jTabbedPane;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}