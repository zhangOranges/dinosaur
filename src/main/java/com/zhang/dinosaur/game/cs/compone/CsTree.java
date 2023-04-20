package com.zhang.dinosaur.game.cs.compone;

import javax.swing.*;
import javax.swing.tree.*;

public class CsTree extends JTree {
    public CsTree(TreeModel newModel) {
        super(newModel);
        setEditable(true);
        getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        setShowsRootHandles(true);
//        setCellRenderer(new CsTreeCellRenderer());
    }
}
