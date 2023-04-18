package com.zhang.dinosaur.game.cs.jpanel;

/* @program: dinosaur
 * @description: ip panel
 * @author: csy
 * @date: 2023-04-17 19:02
 **/

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.context.LContext;
import com.zhang.dinosaur.game.cs.event.LoadingIpEvent;
import com.zhang.dinosaur.game.cs.listener.ConnectionSucceedEventListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class IpInfoPanel extends JPanel implements ConnectionSucceedEventListener<LoadingIpEvent> {
    public IpInfoPanel(){
        super(new MigLayout("flowx,,wrap","[grow,fill]",""));
        this.add(LContext.getIpJLabel());
        this.setBorder( BorderFactory.createMatteBorder(1,1,1,1, Color.LIGHT_GRAY) );
        GContextEventBus.register(this);
    }

    @Override
    @Subscribe
    public void action(LoadingIpEvent o) {
        Component[] components = this.getComponents();
        for (Component component : components) {
            JLabel label = (JLabel) component;
            if(label.getText().contains("IP")){
                //替换IP显示
                label.setText(o.getIp());
            }
        }
    }

}
