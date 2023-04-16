package com.zhang.dinosaur.game.cs.jframe;

import com.zhang.dinosaur.game.context.GContext;
import com.zhang.dinosaur.game.cs.dapter.windowClosingAdapter;
import com.zhang.dinosaur.game.cs.jpanel.*;
import com.zhang.dinosaur.game.cs.button.RemovableButtonTabComponent;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.zhang.dinosaur.game.context.GContext._default_title;
import static com.zhang.dinosaur.game.context.GContext._prefix_title;

/**
 * 主界面
 */
public class MainFrame extends JFrame {
    /**
     * 主面板
     * new MigLayout("", "[grow 15,fill][grow 85,fill]", "[grow,fill][grow,fill]")
     */
    private JPanel contentPanel = new ContentPanel();
    /**
     * 主面板左侧
     */
    private JPanel mainLeftPanel = new MainLeftPanel();
    /**
     * 主面板右侧
     */
    private JPanel mainRightPanel = new MainRightPanel();

    /**
     * 主面板右侧的中间
     */
    private JPanel mainPanel = new MainPanel();
    private JPanel defaultPanel = new DefaultPanel();
    /**
     * 主面板右侧的下边
     */
    private JTabbedPane southTabPane = new JTabbedPane();
    /**
     * 主面板右侧的上边
     */
    private JPanel topPanel = new TopPanel(new MigLayout());
    /**
     * 右侧上边的tab
     */
    private final JTabbedPane pane = new JTabbedPane();

    public MainFrame(){
        super("MainFrame view");
        {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new windowClosingAdapter());
//            setResizable(false);
            setSize(1200,800);
            setPreferredSize(new Dimension(1200,800));
            setLocationRelativeTo(null);
        }

        {
          //todo 左侧添加区域 mainLeftPanel.add
        }

        {

            //添加默认的title panel
            pane.add(_default_title, defaultPanel);
            ((DefaultPanel)defaultPanel).setPanel(pane);
            ((DefaultPanel)defaultPanel).setTitle(_default_title);
            pane.setTabComponentAt(0,new RemovableButtonTabComponent(pane));
            pane.add("+",new JPanel());
            pane.getModel().addChangeListener(new ChangeListener() {
                //count start 2
                private long count = 2;
                private boolean ignore = false;
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (!ignore){
                        ignore=true;
                        try {
                            int selectedIndex = pane.getSelectedIndex();

                            String title = pane.getTitleAt(selectedIndex);
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
                            }


                        }finally {
                            ignore = false;
                        }
                    }
                }
            });


            mainRightPanel.add(pane,"grow");
        }

        {
            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, mainLeftPanel, mainRightPanel);
            splitPane.setOneTouchExpandable(true);
            splitPane.setContinuousLayout(true);
            splitPane.setDividerSize(1);
            splitPane.setDividerLocation(150);
            splitPane.setOpaque(false);
            splitPane.setBorder(null);




            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("基本信息",splitPane);
            contentPanel.add(tabbedPane);
        }



        setContentPane(contentPanel);

        setVisible(true);
    }
}
