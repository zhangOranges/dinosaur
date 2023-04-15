package com.zhang.dinosaur.game.cs.compone;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class CsTree extends JTree {
    public CsTree(TreeNode root) {
        super(root);
        setCellRenderer(new CsTreeCellRenderer());
    }
}
