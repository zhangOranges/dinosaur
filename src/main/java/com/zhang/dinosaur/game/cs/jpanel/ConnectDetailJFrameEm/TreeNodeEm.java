package com.zhang.dinosaur.game.cs.jpanel.ConnectDetailJFrameEm;

import com.zhang.dinosaur.game.cs.jpanel.SSHJPanel;

import javax.swing.*;

public enum TreeNodeEm {

    ssh("SSH连接",
            new SSHJPanel())
    ,zd("终端",
            new NoJPanel())
    ,dl("代理",
            new NoJPanel())
    ,sd("隧道",
            new NoJPanel())
    ;
    ;
    private String name;
    private JPanel jp;
    TreeNodeEm(String name,JPanel jp){
        this.name = name;
        this.jp = jp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JPanel getJp() {
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public static JPanel getJPanelByName(String name){
        for (TreeNodeEm value : values()) {
            if (value.name.equals(name)){
                return value.getJp();
            }
        }
        return null;
    }
}
