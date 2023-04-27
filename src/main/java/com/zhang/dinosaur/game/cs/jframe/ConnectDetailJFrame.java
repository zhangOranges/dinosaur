package com.zhang.dinosaur.game.cs.jframe;

import com.zhang.dinosaur.game.common.ConnectProperties;
import com.zhang.dinosaur.game.cs.button.CsJButton;
import com.zhang.dinosaur.game.cs.jpanel.SSHJPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

import static javax.swing.tree.TreeSelectionModel.SINGLE_TREE_SELECTION;

public class ConnectDetailJFrame extends JFrame {
    public ConnectDetailJFrame( ConnectProperties connectProperties) {
        super();
        String title = "新建连接";
        if (connectProperties != null){
            title = "修改连接";
            {
                //todo   properties set in frame
            }
        }
        setTitle(title);
        JPanel connectPanel = new JPanel(new MigLayout("insets 0,wrap","grow,fill","[grow 99,fill]0[grow 1,fill]"));
        {
            //three part
            JPanel top = new JPanel(new MigLayout("insets 1","[grow 25,fill]0[grow 75,fill]","grow,fill"));
            {
                JPanel top_left = new JPanel(new MigLayout("","grow,fill","grow,fill"));
                {
                    //left component
                    JTree jTree = initTree();
                    top_left.add(jTree);
                }
                JPanel top_right = new JPanel(new MigLayout("","grow,fill","grow,fill"));
                {
                    //ssh panel
                    JPanel sshPanel = new SSHJPanel();
                    top_right.add(sshPanel);
                }
                top.add(top_left);
                top.add(top_right);
            }
            JPanel bottom = new JPanel(new MigLayout("right,center"));
            initBottom(bottom);

            connectPanel.add(top);
            connectPanel.add(bottom);

        }
        add(connectPanel);
        setSize(610,560);
        setLocationRelativeTo(null);
    }

    /**
     * init bottom button
     * @param bottom
     */
    private void initBottom(JPanel bottom) {
        JButton ok = new CsJButton("确认");
        JButton apply = new CsJButton("应用");
        JButton cancel = new CsJButton("取消");
        bottom.add(ok,"wmin 40");
        bottom.add(apply,"wmin 40");
        bottom.add(cancel,"wmin 40");
    }

    /**
     * init tree
     */
    private JTree initTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("SSH连接");
        DefaultMutableTreeNode terminal = new DefaultMutableTreeNode("终端");
        DefaultMutableTreeNode proxy = new DefaultMutableTreeNode("代理");
        DefaultMutableTreeNode tunnel = new DefaultMutableTreeNode("隧道");
        root.add(terminal);
        root.add(proxy);
        root.add(tunnel);
        JTree jTree = new JTree(root);
        jTree.getSelectionModel().setSelectionMode(SINGLE_TREE_SELECTION);
        jTree.addTreeSelectionListener(e->{
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
            String name = (String) node.getUserObject();
            if ("SSH连接".equals(name)){

            }else if ("终端".equals(name)){

            }else if ("代理".equals(name)){

            }else if ("隧道".equals(name)){

            }
        });
        return jTree;
    }
}
