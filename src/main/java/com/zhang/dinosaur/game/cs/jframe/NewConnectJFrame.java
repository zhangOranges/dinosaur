package com.zhang.dinosaur.game.cs.jframe;

import com.zhang.dinosaur.game.cs.jpanel.ConnectListPanel;
import com.zhang.dinosaur.game.cs.jpanel.ConnectToolBarPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class NewConnectJFrame extends JFrame {
    public NewConnectJFrame() throws HeadlessException {
        super();
        JPanel connectPanel = new JPanel(new MigLayout("insets 0 0 0 0,wrap","grow,fill","grow,fill"));

        connectPanel.add(new ConnectToolBarPanel());
        connectPanel.add(new ConnectListPanel());


        add(connectPanel);
        setSize(700,300);
        setLocationRelativeTo(null);
    }
}
