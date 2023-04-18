package com.zhang.dinosaur.game.cs.button;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.context.GContext;
import com.zhang.dinosaur.game.cs.event.LoadingIpEvent;
import com.zhang.dinosaur.game.cs.event.IndexChangeEvent;
import com.zhang.dinosaur.game.cs.jpanel.DefaultPanel;
import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Component to be used as tabComponent;
 * Contains a JLabel to show the text and
 * a JButton to close the tab it belongs to
 */
@Slf4j
public class RemovableButtonTabComponent extends JPanel {
    private final JTabbedPane pane;
    //tab  properties
    private Map<String,String> map = new HashMap<>();
    public RemovableButtonTabComponent(final JTabbedPane pane) {
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
                int i = pane.indexOfTabComponent(RemovableButtonTabComponent.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };

        add(label);
        //add more space between the label and the button
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        //tab button
        JButton button = new TabButton();
        add(button);
        //add more space to the top of the component
        setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }

    public Map<String, String> getMap() {
        return map;
    }

    private class TabButton extends JButton implements ActionListener {
        private int defTabIndex = 1;
        public TabButton() {
            int size = 17;
            setPreferredSize(new Dimension(size, size));
            setToolTipText("close this tab");
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
            int i = pane.indexOfTabComponent(RemovableButtonTabComponent.this);
            //one remove tab
            if (i != -1) {
                int initTab = 3;
                int tabCount = pane.getTabCount();



                //if only three tab and i eq 1   only change title
                if (tabCount>initTab|| i!=defTabIndex){
                    pane.remove(i);
                }else{
                    pane.setTitleAt(i,GContext._default_title);
                    DefaultPanel defaultPanel = new DefaultPanel();
                    defaultPanel.setTitle(GContext._default_title);
                    defaultPanel.setPanel(pane);
                    pane.setComponentAt(i,defaultPanel);
                    //最后一个标签页,清除ip信息
                    GContextEventBus.post(new LoadingIpEvent());
                }

                //
                tabCount = pane.getTabCount();
                if (tabCount<initTab){
//                    //con  init tab
                    DefaultPanel defaultPanel = new DefaultPanel();
                    defaultPanel.setTitle(GContext._default_title);
                    defaultPanel.setPanel(pane);

                    pane.setSelectedIndex(defTabIndex);
                    pane.insertTab(GContext._default_title,null,defaultPanel,null,defTabIndex);
                    pane.setTabComponentAt(defTabIndex,new RemovableButtonTabComponent(pane));

                }else if(tabCount > initTab){
                    int selectedIndex = pane.getSelectedIndex();
                    pane.setSelectedComponent(pane.getComponentAt(selectedIndex));
                }else{
                    pane.setSelectedComponent(pane.getComponentAt(defTabIndex));
                }

                GContextEventBus.post(new IndexChangeEvent(pane.getSelectedIndex()));
            }
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
            int delta = 6;
            g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
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
