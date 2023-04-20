package com.zhang.dinosaur.game.cs.jpanel;

import com.google.common.eventbus.Subscribe;
import com.zhang.dinosaur.game.bus.GContextEventBus;
import com.zhang.dinosaur.game.common.ConnectProperties;
import com.zhang.dinosaur.game.context.GContext;
import com.zhang.dinosaur.game.cs.button.RemovableButtonTabComponent;
import com.zhang.dinosaur.game.cs.compone.InputTextArea;
import com.zhang.dinosaur.game.cs.compone.ShowTextArea;
import com.zhang.dinosaur.game.cs.dapter.OpenFolderMouseAdapter;
import com.zhang.dinosaur.game.cs.event.*;
import com.zhang.dinosaur.game.cs.listener.IndexChangeEventListener;
import com.zhang.dinosaur.game.cs.listener.RightTabbedPaneEventListener;
import com.zhang.dinosaur.game.cs.listener.def.RightPanelTabChangeListener;
import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;


import java.awt.*;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

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
        //add new tab and panel
        addTabAndPanel((t)->{
            DefaultPanel defaultPanel = new DefaultPanel();
            defaultPanel.setTitle(t);
            defaultPanel.setPanel(this);
            return defaultPanel;
        },null);
        //新建tab时，清除ip信息
        GContextEventBus.post(new LoadingIpEvent());
    }
    public void addTabAndPanel(Function<String,JPanel> func, Supplier<String> host){
        int tabCount = getTabCount();
        int idx = tabCount - 1;
        String newTitle =_prefix_title+" "+(count);

        JPanel panel = func.apply(newTitle);
        if (host != null) {
            newTitle = host.get();
        }
        insertTab(newTitle,null,panel,null,idx);
        setTabComponentAt(idx,new RemovableButtonTabComponent(this));
        setSelectedIndex(idx);
        count++;
        lastIndex = idx;
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
    @Subscribe
    public void action(RightTabbedPaneClickSelectLastIndexEvent e) {
        setSelectedIndex(lastIndex);
    }

    @Override
    @Subscribe
    public void action(RTPChangeSelectTabDefaultPanelEvent e) {
        String title = e.getTitle();
        ConnectProperties connectProperties = e.getConnectProperties();
        String alias = connectProperties.getAlias();
        //通过点击  去connect host
        int i = indexOfTab(title);
        JPanel mainRightPanel = getMainRightPanel(connectProperties);

        setComponentAt(i,mainRightPanel);
        setTitleAt(i, alias);

        //add properties
        Component tabComponentAt = getTabComponentAt(i);
        if (tabComponentAt instanceof RemovableButtonTabComponent){
            ((RemovableButtonTabComponent) tabComponentAt).setConnectProperties(connectProperties);
        }
        //双击后触发IP更新事件
        GContextEventBus.post(new LoadingIpEvent(alias));
    }

    @Override
    @Subscribe
    public void action(RTPAddTabConnectPanelEvent e) {
        ConnectProperties connectProperties = e.getConnectProperties();
        String alias = connectProperties.getAlias();
        addTabAndPanel((t)-> getMainRightPanel(connectProperties),()-> alias);
    }

    @Override
    @Subscribe
    public void action(IndexChangeEvent o) {
        lastIndex = o.getCurIndex();
    }


    public JPanel getMainRightPanel(ConnectProperties connectProperties){
        JPanel mainRightPanel = new JPanel(new MigLayout("insets 0 0 0 0,wrap,fill","[grow,fill]","[grow,fill]"));

        MainPanel mainPanel = new MainPanel();

        JPanel mainPanel2 = new JPanel(new MigLayout("wrap,insets 0 0 0 0","grow,fill","[]0[]"));
        mainPanel2.setOpaque(false);

        JTextArea noEditTextArea = new ShowTextArea();



        GContextEventBus.post(new ShowTextAddContentEvent("connect server...",null));
        JTextArea jTextArea = new InputTextArea();

        mainPanel2.add(noEditTextArea);
        mainPanel2.add(jTextArea);
        JScrollPane scrollPane = new MainJScrollPane(mainPanel2);

        mainPanel.add(scrollPane);

        //add text
        mainPanel.add(new MainToolBarPanel());

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.add("file",new FilePanel());

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, mainPanel, jTabbedPane);
        splitPane.setDividerLocation(500);


        mainRightPanel.add(splitPane);

        return mainRightPanel;
    }
}
