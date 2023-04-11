package com.zhang.dinosaur.game.cs.compone;

import javax.swing.text.DefaultCaret;
import java.awt.*;

/**
 * custom caret
 */
public class CsCaret extends DefaultCaret {

    @Override
    public void paint(Graphics g) {
//        ((Graphics2D)g).setStroke();
        super.paint(g);
    }

    @Override
    protected synchronized void damage(Rectangle r) {
//        super.damage(r);
        if (r != null) {
            int damageWidth = 10;
            x = r.x - 4 - (damageWidth >> 1);
            y = r.y;
            width = 9 + damageWidth;
            height = r.height;
            repaint();
        }
    }
}
