package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.button.RemovableButtonTabComponent;
import com.zhang.dinosaur.game.cs.listener.def.RightPanelTabChangeListener;

import javax.swing.*;

import java.awt.*;

import static com.zhang.dinosaur.game.context.GContext._default_title;

/**
 * 右侧tab panel
 */
public class RightTabbedPane extends JTabbedPane {
    private JPanel defaultPanel = new DefaultPanel();
    public RightTabbedPane() {
        addTab("",new ImageIcon(getClass().getResource("/img/open_folder.png")),null);
        //添加默认的title panel
        add(_default_title, defaultPanel);
        ((DefaultPanel)defaultPanel).setPanel(this);
        ((DefaultPanel)defaultPanel).setTitle(_default_title);
        setTabComponentAt(1,new RemovableButtonTabComponent(this));
        setSelectedIndex(1);
        add("+",new JPanel());

        getModel().addChangeListener(new RightPanelTabChangeListener(this));

    }
}
