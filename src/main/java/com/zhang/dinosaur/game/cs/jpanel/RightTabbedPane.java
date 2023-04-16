package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.button.RemovableButtonTabComponent;
import com.zhang.dinosaur.game.cs.listener.def.RightPanelTabChangeListener;

import javax.swing.*;

import static com.zhang.dinosaur.game.context.GContext._default_title;

/**
 * 右侧tab panel
 */
public class RightTabbedPane extends JTabbedPane {
    private JPanel defaultPanel = new DefaultPanel();
    public RightTabbedPane() {
        //添加默认的title panel
        add(_default_title, defaultPanel);
        ((DefaultPanel)defaultPanel).setPanel(this);
        ((DefaultPanel)defaultPanel).setTitle(_default_title);
        setTabComponentAt(0,new RemovableButtonTabComponent(this));
        add("+",new JPanel());

        getModel().addChangeListener(new RightPanelTabChangeListener(this));
    }
}
