package com.zhang.dinosaur.game.cs.button;

import javax.swing.*;


public class FreshJButton extends JButton {
    public FreshJButton() {
        super();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/fresh.png"));
        setIcon(imageIcon);
        setToolTipText("刷新");
    }
}
