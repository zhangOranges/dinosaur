package com.zhang.dinosaur.game.cs.compone;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CsScrollBarUI extends BasicScrollBarUI {

    @Override
    protected void configureScrollBarColors() {
        this.thumbColor = new Color(0x00, 0x00, 0x00,150);
        this.trackColor = new Color(0xFF, 0xFF, 0xFF,0);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }
        };
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }
        };
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(thumbColor);
        g2.fillRoundRect(thumbBounds.x + 2, thumbBounds.y + 2,
                thumbBounds.width - 4, thumbBounds.height - 4,
                thumbBounds.width - 4, thumbBounds.width - 4);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(trackColor);
        g2.fillRoundRect(trackBounds.x + 2, trackBounds.y + 2,
                trackBounds.width - 4, trackBounds.height - 4,
                trackBounds.width - 4, trackBounds.width - 4);
    }
}
