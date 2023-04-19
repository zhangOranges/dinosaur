package com.zhang.dinosaur.game.cs.jpanel;

import javax.swing.*;
import java.awt.*;

public class RoundedJScrollPane extends JScrollPane {
    public RoundedJScrollPane(Component view) {
        super(view);
        setBorder(BorderFactory.createEmptyBorder());
        setBackground(new Color(0,0,0,100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 5, 5);
        super.paintComponent(g2);
        g2.dispose();
    }
}
