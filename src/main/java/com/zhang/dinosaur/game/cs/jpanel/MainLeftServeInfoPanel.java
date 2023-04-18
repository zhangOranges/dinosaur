package com.zhang.dinosaur.game.cs.jpanel;

/* @program: dinosaur
 * @description: 左侧面板--服务器基本信息panel
 * @author: csy
 * @date: 2023-04-17 15:09
 **/

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.context.LContext;
import com.zhang.dinosaur.game.cs.event.LoadingServerInfoEvent;
import com.zhang.dinosaur.game.cs.listener.ConnectionSucceedEventListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainLeftServeInfoPanel extends JPanel implements ConnectionSucceedEventListener<LoadingServerInfoEvent> {
    public MainLeftServeInfoPanel(){
        super(new MigLayout("flowx,,wrap","[grow,fill]",""));
        this.add(LContext.getRunJLabel());
        this.add(LContext.getLoadJLabel());
        this.add(LContext.getCpuJLabel());
        this.add(LContext.getMemJLabel());
        this.add(LContext.getExgJLabel());
        this.setBorder( BorderFactory.createMatteBorder(1,1,1,1, Color.LIGHT_GRAY) );
        GContextEventBus.register(this);
    }

    @Override
    @Subscribe
    public void action(LoadingServerInfoEvent o) {

    }

    public SystemConstantPanel getSystemConstantPanel(){
        return this.new SystemConstantPanel();
    }

    public class SystemConstantPanel extends JPanel {
        public SystemConstantPanel(){
            super(new MigLayout("flowx,,wrap","[grow,fill]",""));
            this.add(LContext.getSystemLabel());
            this.setBackground(Color.GRAY);
            this.setBorder( BorderFactory.createMatteBorder(1,1,1,1, Color.LIGHT_GRAY) );
        }
    }
}
