package com.zhang.dinosaur.game.cs.button;

import com.zhang.dinosaur.game.cs.jpanel.DefaultPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;

import static com.zhang.dinosaur.game.GContext._prefix_title;

/**
 * AddTabButtonComponent cp BTC
 */
public class AddTabButtonComponent extends JPanel {
    private final JTabbedPane pane;

    public AddTabButtonComponent(final JTabbedPane pane) {
        //unset default FlowLayout' gaps
        super(new MigLayout("left,insets 0 0 0 0"));
        if (pane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane = pane;
        setOpaque(false);

        //make JLabel read titles from JTabbedPane
        JLabel label = new JLabel() {
            public String getText() {
                int i = pane.indexOfTabComponent(AddTabButtonComponent.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };

        //add more space between the label and the button
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        //tab button
        JButton button = new AddTabButton();
        add(button);
        //add more space to the top of the component
        setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }

    private class AddTabButton extends JButton implements ActionListener {
        public AddTabButton() {
            int size = 18;
            setPreferredSize(new Dimension(size, size));
            setToolTipText("add title");
            //Make the button looks the same for all Laf's
            setUI(new BasicButtonUI());
            //Make it transparent
            setContentAreaFilled(false);
            //No need to be focusable
            setFocusable(false);
            setBorder(BorderFactory.createEtchedBorder());
            setBorderPainted(false);
            //Making nice rollover effect
            //we use the same listener for all buttons
            addMouseListener(buttonMouseListener);
            setRolloverEnabled(true);
            //Close the proper tab by clicking the button
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            int tabCount = pane.getTabCount();
            int idx = tabCount - 1;
            String title =_prefix_title+(tabCount);

            DefaultPanel defaultPanel = new DefaultPanel();
            defaultPanel.setTitle(title);
            defaultPanel.setPanel(pane);

            pane.insertTab(title,null,defaultPanel,null,idx);
            pane.setTabComponentAt(idx,new ButtonTabComponent(pane));
            pane.setSelectedIndex(idx);
        }

        //we don't want to update UI for this button
        public void updateUI() {
        }

        //paint the cross
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            //shift the image for pressed buttons
            if (getModel().isPressed()) {
                g2.translate(1, 1);
            }
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            if (getModel().isRollover()) {
                g2.setColor(Color.MAGENTA);
            }
            //17 * 17
            //
            int delta = 6;
            g2.drawLine(getWidth()/2, 0+delta, getWidth()/2, getHeight()-delta);
            g2.drawLine(0+delta, getHeight()/2, getWidth()-delta, getHeight()/2);
            g2.dispose();
        }
    }

    private final static MouseListener buttonMouseListener = new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }

        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };
}
