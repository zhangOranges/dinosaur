package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 主面板
 */
public class MainPanel extends JPanel {
    private Image img;
    public MainPanel() {
        super(new MigLayout());
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/default_bg.png"));
        img = imageIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }
}
