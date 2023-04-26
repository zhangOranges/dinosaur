package com.zhang.dinosaur.game.cs.jframe;

import com.zhang.dinosaur.game.cs.dapter.windowClosingAdapter;
import com.zhang.dinosaur.game.cs.jpanel.*;

import javax.swing.*;
import java.awt.*;


/**
 * 主界面
 */
public class MainFrame extends JFrame {
    /**
     * 主面板
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
     * 右侧上边的tab
     */
    private final JTabbedPane pane = new RightTabbedPane();

    /**
     * 左侧--ip信息
     */
    private final IpInfoPanel ipInfoPanel = new IpInfoPanel();

    /**
     * 左侧--服务器基本信息
     */
    private final MainLeftServeInfoPanel serverInfoPanel = new MainLeftServeInfoPanel();

    /**
     * 左侧--ping值监控信息
     */
    private final MainLeftPingInfoPanel pingInfoPanel = new MainLeftPingInfoPanel();

    public MainFrame(){
        super("MainFrame view");
        {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new windowClosingAdapter());
//            setResizable(false);
            setSize(1200,840);
            setPreferredSize(new Dimension(1200,840));
            setLocationRelativeTo(null);
        }

        {
          //todo 左侧添加区域 mainLeftPanel.add
            //ip
            mainLeftPanel.add(ipInfoPanel);
            //系统信息标题
            mainLeftPanel.add(serverInfoPanel.getSystemConstantPanel());
            //具体系统信息
            mainLeftPanel.add(serverInfoPanel);
            //添加ping值监控信息
            mainLeftPanel.add(pingInfoPanel);
        }

        {
            //右侧panel
            mainRightPanel.add(pane,"grow");
        }

        {
            //左右panel放入   tabbedPane  再放入contentPanel
            JSplitPane splitPane = new CsJSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, mainLeftPanel, mainRightPanel);
            //调整左侧宽度
            splitPane.setDividerLocation(250);
            contentPanel.add(splitPane);
        }

        setContentPane(contentPanel);
        setVisible(true);
    }
}
