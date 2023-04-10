package com.zhang.dinosaur.game.cs.jpanel;

import javax.swing.*;
import java.awt.*;

/**
 * 主面板
 */
public class MainPanel extends JPanel {
    private Image img;
    public MainPanel(LayoutManager layout,String imgurl) {
        super(layout);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imgurl));
        img = imageIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }
}
