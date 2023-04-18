package com.zhang.dinosaur.game.cs.jpanel;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.button.FreshJButton;
import com.zhang.dinosaur.game.cs.compone.CsTree;
import com.zhang.dinosaur.game.cs.compone.FileTable;
import com.zhang.dinosaur.game.cs.compone.JTextFieldHint;
import com.zhang.dinosaur.game.cs.event.ConnectionSucceedEvent;
import com.zhang.dinosaur.game.cs.event.LoadingRemoteDirEvent;
import com.zhang.dinosaur.game.cs.event.TreeClickedEvent;
import com.zhang.dinosaur.game.cs.listener.ConnectionSucceedEventListener;
import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.VariableHeightLayoutCache;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Slf4j
public class FilePanel extends JPanel implements ConnectionSucceedEventListener<LoadingRemoteDirEvent> {
    private DefaultMutableTreeNode root =
            new DefaultMutableTreeNode("/");
    private  JTree tree1 = null;
    private  JScrollPane left = new JScrollPane();
    public FilePanel() {
        super(new MigLayout("wrap","grow,fill","[grow 5,fill][grow 95,fill]"));
        JPanel top = new JPanel(new MigLayout("","[grow 90,fill][grow 10,fill]", ""));
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
        if (o instanceof LoadingRemoteDirEvent){
            MutableTreeNode usr = new DefaultMutableTreeNode("usr",false);
            MutableTreeNode mnt = new DefaultMutableTreeNode("mnt",false);

            root.add(usr);
            root.add(mnt);
            for (int i = 0; i < 20; i++) {
                root.add(new DefaultMutableTreeNode("test"+i,false));
            }

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
}
