package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.compone.CsCaret;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;


public class MainJTextPane extends JTextPane {
    public MainJTextPane(boolean isedit) {
        CsCaret csCaret = new CsCaret();
        csCaret.setBlinkRate(500);
        setCaret(csCaret);
        setOpaque(false);
        setCaretColor(Color.GREEN);
        setForeground(Color.WHITE);
        setFont(new Font("", Font.PLAIN, 17));
        setEditorKit(new WrapEditorKit());
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setEditable(isedit);
        setPreferredSize(new Dimension(100,20));

//        setDocument(new WrapDocument());

    }
    @Override
    public boolean getScrollableTracksViewportWidth() {
        return super.getScrollableTracksViewportWidth();
    }
    private class WrapEditorKit extends StyledEditorKit {
        private final ViewFactory defaultFactory = new WrapColumnFactory();

        @Override
        public ViewFactory getViewFactory() {
            return defaultFactory;
        }
    }
    class WrapDocument extends DefaultStyledDocument {
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null || str.isEmpty()) {
                super.insertString(offs, str, a);
                return;
            }

            char[] chars = str.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                    super.insertString(offs++, String.valueOf(chars[i]), a);
            }
        }
    }
    private class WrapColumnFactory implements ViewFactory {
        @Override
        public View create(final Element element) {
            final String kind = element.getName();
            if (kind != null) {
                switch (kind) {
                    case AbstractDocument.ContentElementName:
                        return new WrapLabelView(element);
                    case AbstractDocument.ParagraphElementName:
                        return new ParagraphView(element);
                    case AbstractDocument.SectionElementName:
                        return new BoxView(element, View.Y_AXIS);
                    case StyleConstants.ComponentElementName:
                        return new ComponentView(element);
                    case StyleConstants.IconElementName:
                        return new IconView(element);
                }
            }

            // Default to text display.
            return new LabelView(element);
        }
    }

    private class WrapLabelView extends LabelView {
        public WrapLabelView(final Element element) {
            super(element);
        }

        @Override
        public float getMinimumSpan(final int axis) {
            switch (axis) {
                case View.X_AXIS:
                    return 0;
                case View.Y_AXIS:
                    return super.getMinimumSpan(axis);
                default:
                    throw new IllegalArgumentException("Invalid axis: " + axis);
            }
        }
    }
}
