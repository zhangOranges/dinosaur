package com.zhang.dinosaur.game.cs.button;

import javax.swing.*;

public class LevelUpJButton extends JButton {
    public LevelUpJButton() {
        super();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/levelup.png"));
        setIcon(imageIcon);
        setToolTipText("上一级");
    }
}
