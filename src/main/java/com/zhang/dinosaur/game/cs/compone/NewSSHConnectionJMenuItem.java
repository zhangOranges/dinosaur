package com.zhang.dinosaur.game.cs.compone;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
@Slf4j
public class NewSSHConnectionJMenuItem extends JMenuItem {
    public NewSSHConnectionJMenuItem() {
        super("New SSH Connection");
        addActionListener(e -> clicked());
    }
    public void clicked(){
        log.debug("clicked New SSH Connection");
    }
}
