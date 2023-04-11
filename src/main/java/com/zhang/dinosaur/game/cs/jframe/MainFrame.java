package com.zhang.dinosaur.game.cs.jframe;

import com.zhang.dinosaur.game.cs.jpanel.*;
import com.zhang.dinosaur.game.cs.button.AddTabButtonComponent;
import com.zhang.dinosaur.game.cs.button.ButtonTabComponent;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.zhang.dinosaur.game.context.GContext._default_title;

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
                    mainPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
                    southTabPane.setBorder(BorderFactory.createLineBorder(Color.RED));
                    defaultPanel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        }

        {
          //左侧添加区域
        }

        {

            //添加默认的title panel
            pane.add(_default_title, defaultPanel);
            ((DefaultPanel)defaultPanel).setPanel(pane);
            ((DefaultPanel)defaultPanel).setTitle(_default_title);
            pane.setTabComponentAt(0,new ButtonTabComponent(pane));
            pane.add("",null);
            pane.setTabComponentAt(1,new AddTabButtonComponent(pane));

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
