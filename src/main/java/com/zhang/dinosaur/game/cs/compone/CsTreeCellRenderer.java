package com.zhang.dinosaur.game.cs.compone;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class CsTreeCellRenderer extends DefaultTreeCellRenderer {
    public CsTreeCellRenderer() {
    }

    public CsTreeCellRenderer(Icon icon) {
        leafIcon = icon;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        //设置 叶子节点也是文件夹图标
        if (leaf && value instanceof DefaultMutableTreeNode) {
            setIcon(leafIcon);
        } else if (expanded) {
            setIcon(openIcon);
        } else {
            setIcon(closedIcon);
        }

        return this;
    }
}
