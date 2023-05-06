package com.zhang.dinosaur.game.cs.event;

import com.zhang.dinosaur.game.cs.jpanel.ConnectDetailJFrameEm.TreeNodeEm;
import lombok.Data;

import javax.swing.*;

@Data
public class ChangePanelEvent implements EventObject{

    private String componentName;

    public ChangePanelEvent(String componentName) {
        this.componentName = componentName;
    }

    /**
     * 点击修改面板内容
     * @param jPanel
     */
    public void change(JPanel jPanel){
        JPanel ch = TreeNodeEm.getJPanelByName(componentName);
        jPanel.removeAll();
        jPanel.repaint();
        jPanel.add(ch);
        jPanel.updateUI();
    }
}
