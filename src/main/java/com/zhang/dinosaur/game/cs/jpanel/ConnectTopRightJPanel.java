package com.zhang.dinosaur.game.cs.jpanel;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.event.ChangePanelEvent;
import com.zhang.dinosaur.game.cs.listener.EventListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ConnectTopRightJPanel extends JPanel implements EventListener<ChangePanelEvent> {
    public ConnectTopRightJPanel() {
        super(new MigLayout("","grow,fill","grow,fill"));
        GContextEventBus.register(this);
    }

    @Override
    @Subscribe
    public void action(ChangePanelEvent o) {
        o.change(this);
    }
}
