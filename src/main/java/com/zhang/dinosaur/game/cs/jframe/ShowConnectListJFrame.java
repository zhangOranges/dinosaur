package com.zhang.dinosaur.game.cs.jframe;

import com.zhang.dinosaur.game.cs.jpanel.ConnectListPanel;
import com.zhang.dinosaur.game.cs.jpanel.ConnectToolButtonPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ShowConnectListJFrame extends JFrame {
    public ShowConnectListJFrame() throws HeadlessException {
        super();
        JPanel connectPanel = new JPanel(new MigLayout("insets 0 0 0 0,wrap","grow,fill","[grow 3,fill]0[grow 97,fill]"));

        connectPanel.add(new ConnectToolButtonPanel());
        connectPanel.add(new ConnectListPanel());


        add(connectPanel);
        setSize(700,300);
        setLocationRelativeTo(null);
    }
}
