package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.event.FocusEvent;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * 主面板
 */
public class MainPanel extends JPanel {
    private Image img;
    public MainPanel() {
        super(new MigLayout("ins 10 10 10 10,wrap","grow,fill","[grow 95,fill][grow 5,fill]"));
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/default_bg.png"));
        img = imageIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }
}
