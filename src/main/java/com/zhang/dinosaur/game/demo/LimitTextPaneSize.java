package com.zhang.dinosaur.game.demo;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * @see https://stackoverflow.com/a/15042241/230513
 * @see https://stackoverflow.com/a/14858272/230513
 */
public class LimitTextPaneSize {

    private static final int SIZE = 200;
    private static final double LIMIT = 1 / 3d;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                display();
            }
        });
    }

    private static void display() {
        final JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel topPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(SIZE, SIZE);
            }
        };
        final JTextPane chatArea = new JTextPane();
        final JScrollPane scrollPane = new JScrollPane(chatArea){
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                int desired = (int) (mainPanel.getSize().height * LIMIT);
                int limit = Math.min(desired, d.height);
                return new Dimension(SIZE, limit);
            }
        };
        scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.MAGENTA;
                this.trackColor = Color.MAGENTA;
            }
        });
        chatArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSize();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSize();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSize();
            }

            private void updateSize() {
                mainPanel.revalidate();
            }
        });
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        JFrame f = new JFrame("LimitTextPaneSize");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(mainPanel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}