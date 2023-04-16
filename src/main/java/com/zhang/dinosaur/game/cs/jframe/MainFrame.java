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
            //右侧panel
            mainRightPanel.add(pane,"grow");
        }

        {
            //左右panel放入   tabbedPane  再放入contentPanel
            JTabbedPane tabbedPane = new ContentTabbedPane(mainLeftPanel,mainRightPanel);
            contentPanel.add(tabbedPane);
        }

        setContentPane(contentPanel);
        setVisible(true);
    }
}
