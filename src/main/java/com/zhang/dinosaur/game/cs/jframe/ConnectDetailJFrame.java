package com.zhang.dinosaur.game.cs.jframe;

import com.zhang.dinosaur.game.common.ConnectProperties;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ConnectDetailJFrame extends JFrame {
    public ConnectDetailJFrame( ConnectProperties connectProperties) {
        super();
        String title = "新建连接";
        if (connectProperties != null){
            title = "修改连接";
            {
                //todo   properties set in frame
            }
        }
        setTitle(title);
        JPanel connectPanel = new JPanel(new MigLayout());

        add(connectPanel);
        setSize(700,800);
        setLocationRelativeTo(null);
    }
}
