package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.context.GContext;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

public class FilePanel extends JPanel {
    public FilePanel() {
        super(new MigLayout("wrap","grow,fill","[grow 5,fill][grow 95,fill]"));
        JPanel top = new JPanel(new MigLayout("","[grow 80,fill][grow 10,fill][grow 10,fill]"));
        top.add(new JTextField("flied"));
        top.add(new Button("b1"));
        top.add(new Button("b2"));
        add(top);
        JPanel context = new JPanel(new MigLayout("insets 0 0 0 0","[grow,fill]","grow,fill"));
        context.setBorder(BorderFactory.createLineBorder(Color.cyan));


        DefaultMutableTreeNode root =
                new DefaultMutableTreeNode("The Java Series");


        DefaultMutableTreeNode category = new DefaultMutableTreeNode("Books for Java Programmers");
        root.add(category);

        DefaultMutableTreeNode book = new DefaultMutableTreeNode("test object");
        category.add(book);

        JTree tree1 = new JTree(root);
        JScrollPane left = new JScrollPane(tree1);

        String[] columnNames = {"文件名",
                "大小",
                "类型",
                "修改时间",
                "权限",
                "用户/用户组",
        };
        Object[][] data =null;
        if (data == null){
            data = new Object[][]{
                    {
                            "test1",
                            "test2",
                            "test3",
                            "test4",
                            "test5",
                            "test5",
                    },
            };
        }
        JTable jTable = new JTable(data,columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable.setSelectionMode(SINGLE_SELECTION);


        JScrollPane right = new JScrollPane(jTable);


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, left, right);
        splitPane.setDividerLocation(200);
//        splitPane.setResizeWeight(0.3);
        splitPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        context.add(splitPane);

        add(context);
        setBackground(Color.LIGHT_GRAY);

    }
}
