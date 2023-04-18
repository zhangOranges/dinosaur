package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.compone.NewSSHConnectionJMenuItem;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ConnectToolButtonPanel extends JPanel {
    public ConnectToolButtonPanel() {
        super(new MigLayout());
        JMenu m = new JMenu();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/add_connect.png"));
        m.setIcon(imageIcon);
        m.setOpaque(false);
        m.setPreferredSize(new Dimension(imageIcon.getIconWidth(),imageIcon.getIconHeight()));
        m.setVerticalTextPosition(JMenu.CENTER);
        m.setHorizontalAlignment(JMenu.CENTER);
        JMenuItem jMenuItem = new NewSSHConnectionJMenuItem();
        m.add(jMenuItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(m);
        menuBar.setOpaque(false);



        add(menuBar);

    }
}
