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
        JButton hello = new JButton("hello");
        add(hello);
        hello.addActionListener((e)->{
            int i = jTabbedPane.indexOfTab(title);
            jTabbedPane.setComponentAt(i,new MainPanel());
        });
    }

    public void setPanel(JTabbedPane jTabbedPane) {
        this.jTabbedPane = jTabbedPane;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
