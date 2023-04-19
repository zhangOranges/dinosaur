package com.zhang.dinosaur.game.cs.listener.def;

import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.button.RemovableButtonTabComponent;
import com.zhang.dinosaur.game.cs.event.LoadingIpEvent;
import com.zhang.dinosaur.game.cs.event.RightTabbedPaneClickAddEvent;
import com.zhang.dinosaur.game.cs.event.RightTabbedPaneClickSelectLastIndexEvent;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.util.Map;


/**
 * 右侧面板的tab标签 状态改变监听 实现
 */
@Slf4j
public class RightPanelTabChangeListener implements ChangeListener {
    private JTabbedPane pane = null;
    private boolean ignore = false;

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
