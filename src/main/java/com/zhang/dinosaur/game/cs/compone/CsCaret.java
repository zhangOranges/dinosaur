package com.zhang.dinosaur.game.cs.compone;

import lombok.extern.slf4j.Slf4j;

import javax.swing.plaf.TextUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * custom caret
 */
@Slf4j
public class CsCaret extends DefaultCaret {

    /**
     * Damages the area surrounding the caret to cause
     * it to be repainted.  If paint() is reimplemented,
     * this method should also be reimplemented.
     *
     * @param r  the current location of the caret, does nothing if null
     * @see #paint
     */
    protected void damage(Rectangle r) {
        if (r != null) {
            x = r.x ;
            y = r.y;
            width = r.width + 30;
            height = r.height;
            repaint();
        }
    }

    /**
     * Renders the caret as a vertical line.  If this is reimplemented
     * the damage method should also be reimplemented as it assumes the
     * shape of the caret is a vertical line.  Does nothing if isVisible()
     * is false.  The caret color is derived from getCaretColor() if
     * the component has focus, else from getDisabledTextColor().
     *
     * @param g the graphics context
     * @see #damage
     */
    public void paint(Graphics g) {
        if(isVisible()) {
            try {
                JTextComponent c = getComponent();
                Color fg = c.getCaretColor();
                TextUI mapper = c.getUI();
                int dot = getDot();
                Rectangle r = mapper.modelToView(c, dot);
                g.setColor(fg);
                g.fillRect(r.x, r.y, r.width+10, r.height);
            } catch (BadLocationException e) {
                // can't render I guess
                System.err.println("Can't render caret");
            }
        }
    }
}
