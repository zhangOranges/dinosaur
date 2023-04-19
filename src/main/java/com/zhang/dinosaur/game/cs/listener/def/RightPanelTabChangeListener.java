package com.zhang.dinosaur.game.cs.listener.def;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.button.RemovableButtonTabComponent;
import com.zhang.dinosaur.game.cs.event.IndexChangeEvent;
import com.zhang.dinosaur.game.cs.event.LoadingIpEvent;
import com.zhang.dinosaur.game.cs.event.RightTabbedPaneClickAddEvent;
import com.zhang.dinosaur.game.cs.event.RightTabbedPaneClickSelectLastIndexEvent;
import com.zhang.dinosaur.game.cs.jpanel.DefaultPanel;
import com.zhang.dinosaur.game.cs.listener.IndexChangeEventListener;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.util.Map;

import static com.zhang.dinosaur.game.context.GContext._prefix_title;

/**
 * 右侧面板的tab标签 状态改变监听 实现
 */
@Slf4j
public class RightPanelTabChangeListener implements ChangeListener {
    private JTabbedPane pane = null;
    //count start 3
//    private long count = 2;
    private boolean ignore = false;
//    private int lastIndex = 1;

    public RightPanelTabChangeListener(JTabbedPane pane) {
        this.pane = pane;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (!ignore){
            ignore=true;
            try {
                int selectedIndex = pane.getSelectedIndex();
                if (selectedIndex==-1){
                    GContextEventBus.post(new RightTabbedPaneClickSelectLastIndexEvent());
                    return;
                }
                Component sc = pane.getTabComponentAt(selectedIndex);
                if (sc instanceof RemovableButtonTabComponent){
                    Map<String, String> map = ((RemovableButtonTabComponent) sc).getMap();
                    log.debug("当前切换到的tab的属性 = {} ",map);
                    GContextEventBus.post(new LoadingIpEvent(map.get("host")));
                }
                String title = pane.getTitleAt(selectedIndex);
                //add button
                if ("+".equals(title)){
                    GContextEventBus.post(new RightTabbedPaneClickAddEvent());
                }
            }finally {
                ignore = false;
            }
        }
    }


}
