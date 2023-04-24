package com.zhang.dinosaur.game.cs.compone;

import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

@Slf4j
public class CsLeafPanelTreeCellRenderer  extends DefaultTreeCellRenderer {
    private JPanel jPanel;

    public CsLeafPanelTreeCellRenderer() {
        jPanel = new JPanel(new MigLayout("",""));
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/computer.png"));

        JLabel img = new JLabel(imageIcon);
        jPanel.add(img);
        jPanel.add(new JLabel("hello"));
        jPanel.add(new JLabel("hello1"));
        jPanel.add(new JLabel("hello2"));
        jPanel.add(new JLabel("hello3"));
        jPanel.setOpaque(false);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        setBackgroundSelectionColor(new Color(0,0,0,50));
        setBackgroundNonSelectionColor(new Color(0, 0, 255));
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        //设置 叶子节点也是文件夹图标
        if (leaf && value instanceof DefaultMutableTreeNode) {
            setIcon(leafIcon);
            return jPanel;
        } else if (expanded) {
            setIcon(openIcon);
        } else {
            setIcon(closedIcon);
        }

        return this;
    }
}
