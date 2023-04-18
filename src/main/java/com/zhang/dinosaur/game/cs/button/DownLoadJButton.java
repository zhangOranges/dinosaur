package com.zhang.dinosaur.game.cs.button;

import javax.swing.*;

public class DownLoadJButton extends JButton {
    public DownLoadJButton() {
        super();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/download.png"));
        setIcon(imageIcon);
        setToolTipText("下载");
    }
}
