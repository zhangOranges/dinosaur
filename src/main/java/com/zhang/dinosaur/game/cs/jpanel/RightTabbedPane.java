package com.zhang.dinosaur.game.cs.jpanel;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.context.GContext;
import com.zhang.dinosaur.game.cs.button.RemovableButtonTabComponent;
import com.zhang.dinosaur.game.cs.dapter.OpenFolderMouseAdapter;
import com.zhang.dinosaur.game.cs.event.*;
import com.zhang.dinosaur.game.cs.listener.IndexChangeEventListener;
import com.zhang.dinosaur.game.cs.listener.RightTabbedPaneEventListener;
import com.zhang.dinosaur.game.cs.listener.def.RightPanelTabChangeListener;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;


import static com.zhang.dinosaur.game.context.GContext._default_title;
import static com.zhang.dinosaur.game.context.GContext._prefix_title;

/**
 * 右侧tab panel
 */
@Slf4j
public class RightTabbedPane extends JTabbedPane implements RightTabbedPaneEventListener, IndexChangeEventListener {
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
        addMouseListener(new OpenFolderMouseAdapter(this));

        GContextEventBus.register(this);

    }
    private long count = 2;
    private int lastIndex = 1;
    @Override
    @Subscribe
    public void action(RightTabbedPaneClickAddEvent e) {
        int tabCount = getTabCount();
        int idx = tabCount - 1;
        String newTitle =_prefix_title+" "+(count);

        DefaultPanel defaultPanel = new DefaultPanel();
        defaultPanel.setTitle(newTitle);
        defaultPanel.setPanel(this);

        insertTab(newTitle,null,defaultPanel,null,idx);
        setTabComponentAt(idx,new RemovableButtonTabComponent(this));
        setSelectedIndex(idx);
        count++;
        lastIndex = idx;
        //新建tab时，清除ip信息
        GContextEventBus.post(new LoadingIpEvent());
    }
    private int defTabIndex = 1;
    @Override
    @Subscribe
    public void action(RightTabbedPaneClickRemoveEvent e) {
        int i = indexOfTabComponent(e.getComponent());
        //one remove tab
        if (i != -1) {
            int initTab = 3;
            int tabCount = getTabCount();



            //if only three tab and i eq 1   only change title
            if (tabCount>initTab|| i!=defTabIndex){
                remove(i);
            }else{
                setTitleAt(i, GContext._default_title);
                DefaultPanel defaultPanel = new DefaultPanel();
                defaultPanel.setTitle(GContext._default_title);
                defaultPanel.setPanel(this);
                setComponentAt(i,defaultPanel);
                //最后一个标签页,清除ip信息
                GContextEventBus.post(new LoadingIpEvent());
            }

            //
            tabCount = getTabCount();
            if (tabCount<initTab){
                //con  init tab
                DefaultPanel defaultPanel = new DefaultPanel();
                defaultPanel.setTitle(GContext._default_title);
                defaultPanel.setPanel(this);

                setSelectedIndex(defTabIndex);
                insertTab(GContext._default_title,null,defaultPanel,null,defTabIndex);
                setTabComponentAt(defTabIndex,new RemovableButtonTabComponent(this));

            }else if(tabCount > initTab){
                int selectedIndex = getSelectedIndex();
                setSelectedComponent(getComponentAt(selectedIndex));
            }else{
                setSelectedComponent(getComponentAt(defTabIndex));
            }

            GContextEventBus.post(new IndexChangeEvent(getSelectedIndex()));
        }
    }

    @Override
    public void action(RightTabbedPaneClickSelectLastIndexEvent e) {
        setSelectedIndex(lastIndex);
    }

    @Override
    @Subscribe
    public void action(IndexChangeEvent o) {
        lastIndex = o.getCurIndex();
    }
}
