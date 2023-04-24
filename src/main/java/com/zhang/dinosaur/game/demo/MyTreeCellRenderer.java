package com.zhang.dinosaur.game.demo;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class MyTreeCellRenderer extends JPanel implements TreeCellRenderer {
    private JLabel label;
    private JPanel childPanel;

    public MyTreeCellRenderer() {

        label = new JLabel();
        childPanel = new JPanel();
        add(label, BorderLayout.NORTH);
        add(childPanel, BorderLayout.CENTER);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                  boolean expanded, boolean leaf, int row, boolean hasFocus) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        Object userObject = node.getUserObject();

        if (userObject instanceof String) {
            label.setText(userObject.toString());
        }

        if (userObject instanceof JPanel) {
            JPanel panel = (JPanel) userObject;
            childPanel.removeAll();
            childPanel.add(panel);
//            childPanel.revalidate();
//            childPanel.repaint();
        }

        if (selected) {
            setBackground(UIManager.getColor("Tree.selectionBackground"));
            setForeground(UIManager.getColor("Tree.selectionForeground"));
        } else {
            setBackground(UIManager.getColor("Tree.background"));
            setForeground(UIManager.getColor("Tree.foreground"));
        }

        return this;
    }
}
