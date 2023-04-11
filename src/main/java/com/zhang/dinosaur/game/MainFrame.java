package com.zhang.dinosaur.game;

import com.zhang.dinosaur.game.cs.jpanel.*;
import com.zhang.dinosaur.game.demo.AddTabButtonComponent;
import com.zhang.dinosaur.game.demo.ButtonTabComponent;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT;

/**
 * 主界面
 */
public class MainFrame extends JFrame {
    /**
     * 主面板
     * new MigLayout("", "[grow 15,fill][grow 85,fill]", "[grow,fill][grow,fill]")
     */
    private JPanel contentPanel = new ContentPanel(new MigLayout("", "[grow,fill]", "[grow,fill]"));
    /**
     * 主面板左侧
     */
    private JPanel mainLeftPanel = new MainLeftPanel(new MigLayout("flowx,,wrap","[grow,fill]",""));
    /**
     * 主面板右侧
     */
    private JPanel mainRightPanel = new MainRightPanel(new MigLayout("flowy,fill","","[c,grow 75,fill]0[c,grow 25,fill]"));

    /**
     * 主面板右侧的中间
     */
    private JPanel mainPanel = new MainPanel(new MigLayout(),"/img/default_bg.png");
    private JPanel defaultPanel = new JPanel(new MigLayout());
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
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    if(JOptionPane.showConfirmDialog(null,"close?","Tip",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_NO_OPTION){
                        System.exit(0);
                    }
                }
            });
//            setResizable(false);
            setSize(1000, 750);
            setLocationRelativeTo(null);
        }
        //用于debug
        {
            contentPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                mainLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                mainRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    topPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
                    mainPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
                    southTabPane.setBorder(BorderFactory.createLineBorder(Color.RED));
        }

        {
          //左侧添加区域
        }

        {


//            pane.setTabComponentAt(1,
//                    new ButtonTabComponent(pane));
            pane.add("title1", null);
//            pane.setTabComponentAt(1,
//                    new ButtonTabComponent(pane));
//            topPanel.add(pane);
            pane.setTabComponentAt(0,new ButtonTabComponent(pane));
            pane.add("",null);
            pane.setTabComponentAt(1,new AddTabButtonComponent(pane));
            mainRightPanel.add(pane,"grow");
//            mainRightPanel.add(mainPanel,"grow");
            mainRightPanel.add(southTabPane,"grow");
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
