package com.zhang.dinosaur.game.cs.button;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.event.LoadingRemoteDirEvent;

import javax.swing.*;


public class FreshJButton extends JButton {
    public FreshJButton() {
        super();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/fresh.png"));
        setIcon(imageIcon);
        setToolTipText("刷新");
        addActionListener(e->{
            //todo test loading remote dir
            GContextEventBus.post(new LoadingRemoteDirEvent());
        });
    }
}
