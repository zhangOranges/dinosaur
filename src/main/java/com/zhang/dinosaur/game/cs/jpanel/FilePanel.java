package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.context.GContext;
import com.zhang.dinosaur.game.cs.compone.CsTree;
import com.zhang.dinosaur.game.cs.event.ConnectionSucceedEvent;
import com.zhang.dinosaur.game.cs.event.TreeClickedEvent;
import com.zhang.dinosaur.game.cs.listener.ConnectionSucceedEventListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

public class FilePanel extends JPanel implements ConnectionSucceedEventListener {
    private DefaultMutableTreeNode root =
            new DefaultMutableTreeNode("/");
    private  JTree tree1 = null;
    private  JScrollPane left = new JScrollPane();
    public FilePanel() {
        super(new MigLayout("wrap","grow,fill","[grow 5,fill][grow 95,fill]"));
        JPanel top = new JPanel(new MigLayout("","[grow 80,fill][grow 10,fill][grow 10,fill]"));
        top.add(new JTextField("flied"));
        Button b1 = new Button("b1");
        b1.addActionListener((t)->{
            GContextEventBus.post(new ConnectionSucceedEvent());
            System.out.println("fasong ConnectionSucceedEvent");
        });
        top.add(b1);
        top.add(new Button("b2"));
        add(top);
        JPanel context = new JPanel(new MigLayout("insets 0 0 0 0","[grow,fill]","grow,fill"));
        context.setBorder(BorderFactory.createLineBorder(Color.cyan));







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
        splitPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        context.add(splitPane);

        add(context);
        setBackground(Color.LIGHT_GRAY);


        GContextEventBus.register(this);

    }

    @Override
    public void action(ConnectionSucceedEvent o) {

        MutableTreeNode usr = new DefaultMutableTreeNode("usr",false);
        MutableTreeNode mnt = new DefaultMutableTreeNode("mnt",false);

        root.add(usr);
        root.add(mnt);
        tree1 = new CsTree(root);
        tree1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree1.getLastSelectedPathComponent();
                    if (node == null) return;
                    String path = (String) node.getUserObject();
                    DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
                    for(;;){
                        if (parent == null){
                            break;
                        }
                        path =   parent.getUserObject() + path;
                        parent = (DefaultMutableTreeNode)parent.getParent();
                    }

                    //触发TreeClickedEvent事件    path为 去查看的远程服务器上的文件夹
                    GContextEventBus.post(new TreeClickedEvent(path+""));

                }

            }
        });
        left.setViewportView(tree1);


    }
}
