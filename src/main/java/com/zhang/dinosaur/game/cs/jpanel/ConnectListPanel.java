package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.compone.CsTree;
import com.zhang.dinosaur.game.cs.compone.CsTreeCellRenderer;
import lombok.Data;
import lombok.experimental.Accessors;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import java.awt.*;

public class ConnectListPanel extends JPanel {
    private DefaultMutableTreeNode root =
            new DefaultMutableTreeNode("连接");
    private DefaultTreeModel treeModel;
    private  JTree tree = null;
    private  JScrollPane left = new JScrollPane();
    public ConnectListPanel() {
        super(new MigLayout("","grow,fill"));
        setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        treeModel = new DefaultTreeModel(root);
        createNode();
        tree = new CsTree(treeModel);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/computer.png"));
        tree.setCellRenderer(new CsTreeCellRenderer(imageIcon));
        left.setViewportView(tree);
        add(left);
    }

    private void createNode() {
        ConnectItem connectItem = new ConnectItem();
        connectItem
                .setAlias("alias")
                .setHost("host");
        MutableTreeNode usr = new DefaultMutableTreeNode(connectItem,false);

        root.add(usr);
    }

    @Data
    @Accessors(chain = true)
    static class ConnectItem{
        private String alias;
        private String host;

        @Override
        public String toString() {
            return alias+"      "+host;
        }
    }
}
