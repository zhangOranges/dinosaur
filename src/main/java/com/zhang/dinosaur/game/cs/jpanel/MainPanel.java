package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * 主面板
 */
public class MainPanel extends JPanel {
    private Image img;
    public MainPanel() {
        super(new MigLayout("ins 10 10 10 10,wrap","grow,fill","[grow 95,fill][grow 5,fill]"));
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/default_bg.png"));
        img = imageIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }

//    public static void main(String[] args) {
//
//        SwingUtilities.invokeLater(()->{
//            JFrame jFrame = new JFrame();
//            jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//            jFrame.setSize(1000, 750);
//            jFrame.setLocationRelativeTo(null);
//            MainPanel mainPanel = new MainPanel();
//            {
//
//                JTextPane textPane = new MainJTextPane();
////                textPane.setBorder(BorderFactory.createLineBorder(Color.cyan));
//                final JScrollPane scrollPane = new MainJScrollPane(textPane);
//                mainPanel.add(scrollPane);
//            }
//
//            jFrame.setContentPane(mainPanel);
//            jFrame.setVisible(true);
//        });
//
//    }
}
