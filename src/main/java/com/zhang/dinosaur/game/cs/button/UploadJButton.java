package com.zhang.dinosaur.game.cs.button;

import javax.swing.*;

public class UploadJButton extends JButton {
    public UploadJButton() {
        super();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/upload.png"));
        setIcon(imageIcon);
        setToolTipText("上传");
    }
}
