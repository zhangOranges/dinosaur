package com.zhang.dinosaur.game.cs.jframe;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.common.ConnectProperties;
import com.zhang.dinosaur.game.cs.button.CsJButton;
import com.zhang.dinosaur.game.cs.event.ChangePanelEvent;
import com.zhang.dinosaur.game.cs.jpanel.ConnectDetailJFrameEm.TreeNodeEm;
import com.zhang.dinosaur.game.cs.jpanel.ConnectJPanel;
import com.zhang.dinosaur.game.cs.jpanel.ConnectTopLeftJPanel;
import com.zhang.dinosaur.game.cs.jpanel.ConnectTopRightJPanel;
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
        JPanel connectPanel = new ConnectJPanel();
        {
            //three part
            JPanel top = new JPanel(new MigLayout("insets 1","[grow 25,fill]0[grow 75,fill]","grow,fill"));
            {
                JPanel top_left = new ConnectTopLeftJPanel();
                {
                    //left component
                    JTree jTree = initTree();
                    top_left.add(jTree);
                }
                JPanel top_right = new ConnectTopRightJPanel();
                {
                    //ssh panel
                    JPanel sshPanel = new SSHJPanel();
                    top_right.add(sshPanel);
                }
                top.add(top_left,"wmin 100");
                top.add(top_right,"wmin 500");
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

        //初始化按钮事件 todo 事件未填充
        initButtonAction(ok,()->{});
        initButtonAction(apply,()->{});
        initButtonAction(cancel,()->{});

    }

    public void initButtonAction(JButton button,Runnable runnable){
        button.addActionListener(e -> {
            clickButtonAfter(runnable);
        });
    }
    public void clickButtonAfter(Runnable runnable){
        runnable.run();
        this.dispose();
    }
    /**
     * init tree
     */
    private JTree initTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(TreeNodeEm.ssh.getName());
        DefaultMutableTreeNode terminal = new DefaultMutableTreeNode(TreeNodeEm.zd.getName());
        DefaultMutableTreeNode proxy = new DefaultMutableTreeNode(TreeNodeEm.dl.getName());
        DefaultMutableTreeNode tunnel = new DefaultMutableTreeNode(TreeNodeEm.sd.getName());
        root.add(terminal);
        root.add(proxy);
        root.add(tunnel);
        JTree jTree = new JTree(root);
        jTree.getSelectionModel().setSelectionMode(SINGLE_TREE_SELECTION);
        //默认选中root
        jTree.setSelectionRow(0);
        jTree.addTreeSelectionListener(e->{
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
            String name = (String) node.getUserObject();
            //通知改变panel
            GContextEventBus.post(new ChangePanelEvent(name));
        });
        return jTree;
    }
}
