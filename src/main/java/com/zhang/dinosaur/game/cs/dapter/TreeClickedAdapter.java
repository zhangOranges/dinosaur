package com.zhang.dinosaur.game.cs.dapter;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.compone.CsTree;
import com.zhang.dinosaur.game.cs.event.TreeClickedEvent;
import lombok.extern.slf4j.Slf4j;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
@Slf4j
public class TreeClickedAdapter extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if ( !(e.getSource() instanceof CsTree)){
            log.debug("come on event on CsTree Component event");
            return;
        }
        CsTree tree = (CsTree) e.getSource();
        if (e.getClickCount() == 1) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
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
}
