package com.zhang.dinosaur.game.cs.listener.def;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.cs.button.RemovableButtonTabComponent;
import com.zhang.dinosaur.game.cs.event.IndexChangeEvent;
import com.zhang.dinosaur.game.cs.jpanel.DefaultPanel;
import com.zhang.dinosaur.game.cs.listener.IndexChangeEventListener;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static com.zhang.dinosaur.game.context.GContext._prefix_title;

/**
 * 右侧面板的tab标签 状态改变监听 实现
 */
@Slf4j
public class RightPanelTabChangeListener implements ChangeListener, IndexChangeEventListener {
    private JTabbedPane pane = null;
    //count start 3
    private long count = 2;
    private boolean ignore = false;
    private int lastIndex = 1;

    public RightPanelTabChangeListener(JTabbedPane pane) {
        this.pane = pane;
        GContextEventBus.register(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (!ignore){
            ignore=true;
            try {
                int selectedIndex = pane.getSelectedIndex();
                if (selectedIndex==-1){
                    pane.setSelectedIndex(lastIndex);
                    return;
                }
                String title = pane.getTitleAt(selectedIndex);
                //add button
                if ("+".equals(title)){
                    int tabCount = pane.getTabCount();
                    int idx = tabCount - 1;
                    String newTitle =_prefix_title+" "+(count);

                    DefaultPanel defaultPanel = new DefaultPanel();
                    defaultPanel.setTitle(newTitle);
                    defaultPanel.setPanel(pane);

                    pane.insertTab(newTitle,null,defaultPanel,null,idx);
                    pane.setTabComponentAt(idx,new RemovableButtonTabComponent(pane));
                    pane.setSelectedIndex(idx);
                    count++;
                    lastIndex = idx;
                }else if("".equals(title)){
                    //open folder button
                    log.debug("click open folder selectIndex = {} , lastIndex = {}",selectedIndex,lastIndex);
                }
            }finally {
                ignore = false;
            }
        }
    }

    @Override
    @Subscribe
    public void action(IndexChangeEvent o) {
        lastIndex = o.getCurIndex();
    }
}
