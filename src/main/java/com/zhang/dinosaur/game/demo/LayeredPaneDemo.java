package com.zhang.dinosaur.game.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LayeredPaneDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("LayeredPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(400, 300));

        JLayeredPane layeredPane = new JLayeredPane();

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setBounds(50, 50, 100, 100);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.GREEN);
        panel2.setBounds(75, 75, 100, 100);

        layeredPane.add(panel1, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(panel2, JLayeredPane.DEFAULT_LAYER);

        layeredPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Dimension size = e.getComponent().getSize();
                panel1.setBounds(size.width / 2 - 50, size.height / 2 - 50, 100, 100);
                panel2.setBounds(size.width / 2 - 25, size.height / 2 - 25, 100, 100);
            }
        });

        panel.add(layeredPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }
}
