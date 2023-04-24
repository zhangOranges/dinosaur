package com.zhang.dinosaur.game.cs.jframe;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.event.ShowConnectListJFrameEvent;
import com.zhang.dinosaur.game.cs.jpanel.ConnectListPanel;
import com.zhang.dinosaur.game.cs.jpanel.ConnectToolButtonPanel;
import com.zhang.dinosaur.game.cs.listener.ShowConnectListJFrameListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ShowConnectListJFrame extends JFrame implements ShowConnectListJFrameListener {
    public ShowConnectListJFrame() throws HeadlessException {
        super();
        JPanel connectPanel = new JPanel(new MigLayout("insets 0 0 0 0,wrap","grow,fill","[grow 3,fill]0[grow 97,fill]"));

        connectPanel.add(new ConnectToolButtonPanel());
        connectPanel.add(new ConnectListPanel());


        add(connectPanel);
        setSize(700,300);
        setLocationRelativeTo(null);
        GContextEventBus.register(this);
    }

    @Override
    @Subscribe
    public void action(ShowConnectListJFrameEvent o) {
        setVisible(false);
    }
}
