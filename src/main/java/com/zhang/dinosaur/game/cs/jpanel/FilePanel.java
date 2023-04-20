package com.zhang.dinosaur.game.cs.jpanel;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.button.FreshJButton;
import com.zhang.dinosaur.game.cs.compone.CsTree;
import com.zhang.dinosaur.game.cs.compone.FileTable;
import com.zhang.dinosaur.game.cs.compone.JTextFieldHint;
import com.zhang.dinosaur.game.cs.dapter.TreeClickedAdapter;
import com.zhang.dinosaur.game.cs.event.ConnectionSucceedEvent;
import com.zhang.dinosaur.game.cs.event.LoadingRemoteDirEvent;
import com.zhang.dinosaur.game.cs.event.TreeClickedEvent;
import com.zhang.dinosaur.game.cs.listener.ConnectionSucceedEventListener;
import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.VariableHeightLayoutCache;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Slf4j
public class FilePanel extends JPanel implements ConnectionSucceedEventListener<LoadingRemoteDirEvent> {
    private DefaultMutableTreeNode root =
            new DefaultMutableTreeNode("/");
    private DefaultTreeModel treeModel;
    private  JTree tree = null;
    private  JScrollPane left = new JScrollPane();
    public FilePanel() {
        super(new MigLayout("insets 0 0 0 0,wrap","grow,fill","[grow 5,fill]0[grow 95,fill]"));

        JPanel top = new JPanel(new MigLayout("insets 0 0 0 0","[grow 90,fill][grow 10,fill]", ""));
        top.add(new JTextFieldHint("请输入文本"));


        top.add(new FileButtonsPanel());
        add(top);
        JPanel context = new JPanel(new MigLayout("insets 0 0 0 0","[grow,fill]","grow,fill"));






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
        JTable jTable = new FileTable(data,columnNames);


        JScrollPane right = new JScrollPane(jTable);


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, left, right);
        splitPane.setDividerLocation(200);
//        splitPane.setResizeWeight(0.3);

        context.add(splitPane);

        add(context);
        setBackground(Color.LIGHT_GRAY);


        GContextEventBus.register(this);

    }

    @Override
    @Subscribe
    public void action(LoadingRemoteDirEvent o) {
            treeModel = new DefaultTreeModel(root);
            createNode();
            tree = new CsTree(treeModel);
            tree.addMouseListener(new TreeClickedAdapter());
            left.setViewportView(tree);
    }
    /**
     * test data
     */
    private void createNode(){
        MutableTreeNode usr = new DefaultMutableTreeNode("usr",false);
        MutableTreeNode mnt = new DefaultMutableTreeNode("mnt",false);

        root.add(usr);
        root.add(mnt);
        for (int i = 0; i < 20; i++) {
            root.add(new DefaultMutableTreeNode("test"+i,false));
        }

    }
}
