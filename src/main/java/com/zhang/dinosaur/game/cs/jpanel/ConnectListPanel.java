package com.zhang.dinosaur.game.cs.jpanel;

import cn.hutool.core.bean.BeanUtil;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.common.ConnectItem;
import com.zhang.dinosaur.game.common.ConnectProperties;
import com.zhang.dinosaur.game.context.GContext;
import com.zhang.dinosaur.game.cs.compone.*;
import com.zhang.dinosaur.game.cs.event.RTPAddTabConnectPanelEvent;
import com.zhang.dinosaur.game.cs.event.ShowConnectListJFrameEvent;
import com.zhang.dinosaur.game.cs.jframe.ConnectDetailJFrame;
import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
@Slf4j
public class ConnectListPanel extends JPanel{
    private DefaultMutableTreeNode root =
            new DefaultMutableTreeNode("连接");
    private DefaultTreeModel treeModel;
    private  JTree tree = null;
    private  JScrollPane left = new JScrollPane();

    JPopupMenu popMenu;
    JMenuItem connectItem;
    JMenuItem delItem;
    JMenuItem editItem;

    public ConnectListPanel() {
        super(new MigLayout("","grow,fill"));

        treeModel = new DefaultTreeModel(root);

        createNode();
        tree = new CsTree(treeModel);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setCellRenderer(new CsTreeCellRenderer(new ImageIcon(getClass().getResource("/img/computer.png"))));
        left.setViewportView(tree);
        tree.setEditable(false);
        add(left);

        createPopMenu();

        tree.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        tree.addMouseListener(getMouseAdapter());

    }

    private void createPopMenu(){
        popMenu = new JPopupMenu();
        connectItem = new JMenuItem("连接");

        connectItem.addActionListener(getActionListener());
        delItem = new JMenuItem("删除");
        delItem.addActionListener(getActionListener());
        editItem = new JMenuItem("修改");
        editItem.addActionListener(getActionListener());

        popMenu.add(connectItem);

        popMenu.add(editItem);
        popMenu.add(delItem);
    }
    private void createNode() {
        ConnectItem connectItem = new ConnectItem();
        connectItem
                .setAlias("alias")
                .setHost("host")
                .setPort("22")
                .setUname("test")
                ;
        DefaultMutableTreeNode usr = new DefaultMutableTreeNode(connectItem);
        root.add(usr);
    }




    private ActionListener getActionListener(){
        ActionListener a = e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            ConnectItem item = (ConnectItem) node.getUserObject();
            if (e.getSource() == connectItem) {
                //todo detail no handle
                GContextEventBus.post(new ShowConnectListJFrameEvent());
                ConnectProperties connectProperties = new ConnectProperties();
                BeanUtil.copyProperties(item,connectProperties);
                GContextEventBus.post(new RTPAddTabConnectPanelEvent(connectProperties));
            } else if (e.getSource() == delItem) {
                if (node.isRoot()) {
                    return;
                }
                SwingUtilities.invokeLater(()->{
                    JOptionPane.showMessageDialog(this, "no action");
                });
//                ((DefaultTreeModel) tree.getModel()).removeNodeFromParent(node);

            } else if (e.getSource() == editItem) {
                ConnectProperties connectProperties = new ConnectProperties();
                BeanUtil.copyProperties(item,connectProperties);
                //tod    pop window show edit properties
                ConnectDetailJFrame connectDetailJFrame = new ConnectDetailJFrame(connectProperties);
                connectDetailJFrame.setVisible(true);
            }
        };
        return  a;
    }


    private MouseAdapter getMouseAdapter(){
        return new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // 关键是这个方法的使用
                TreePath path = tree.getPathForLocation(e.getX(), e.getY());
                if (path != null && path.getParentPath()==null){
                    tree.setSelectionPath(null);
                    return;
                }
                tree.setSelectionPath(path);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // 关键是这个方法的使用
                TreePath path = tree.getPathForLocation(e.getX(), e.getY());
                if (path == null) {
                    return;
                }
                tree.setSelectionPath(path);

                if (e.getButton() == 3) {
                    popMenu.show(tree, e.getX(), e.getY());
                }
            }
        };
    }
}
