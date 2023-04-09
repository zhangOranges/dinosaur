package com.zhang.dinosaur.game;

import com.zhang.dinosaur.game.cs.jpanel.MainLeftPanel;
import com.zhang.dinosaur.game.cs.jpanel.MainPanel;
import com.zhang.dinosaur.game.cs.jpanel.TopPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 主界面
 */
public class MainFrame extends JFrame {
    private JPanel contentPanel = new JPanel(new MigLayout("flowx,fill", "[c,grow 15,fill][c,grow 85,fill]", ""));
    private JPanel mainLeftPanel;
    private JPanel mainRightPanel = new JPanel(new MigLayout("flowy,fill","","[c,grow 2,fill][c,grow 73,fill][c,grow 25,fill]"));
    private JPanel mainPanel;
    private JTabbedPane southTabPane = new JTabbedPane();

    private JPanel topPanel = new TopPanel();
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
        {
            mainLeftPanel = new MainLeftPanel(new MigLayout());
            mainLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        {
            topPanel.setBorder(BorderFactory.createLineBorder(Color.RED));

        }

        {
            mainPanel = new MainPanel(new MigLayout(),"img/default_bg.png");
            mainPanel.setBorder(BorderFactory.createLineBorder(Color.RED));

        }

        {
            southTabPane.setBorder(BorderFactory.createLineBorder(Color.RED));
        }

        {
            mainRightPanel.add(topPanel,"grow");
            mainRightPanel.add(mainPanel,"grow");
            mainRightPanel.add(southTabPane,"grow");
            mainRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        {
            contentPanel.add(mainLeftPanel,"spany,grow");
            contentPanel.add(mainRightPanel,"spany,grow");

        }




        setContentPane(contentPanel);

        setVisible(true);
    }
}
