package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

public class MainToolBarPanel extends JPanel {
    public MainToolBarPanel() {
        //todo   add bar
        super(new MigLayout("insets 10 10 -20 0","[grow 80,fill][grow 20,fill]",""));

        setOpaque(false);


        JTextArea jTextArea = new JTextArea();
        jTextArea.setLineWrap(false);
        jTextArea.setWrapStyleWord(false);
        jTextArea.setOpaque(false);
        jTextArea.setCaretColor(Color.green);
        jTextArea.setForeground(Color.WHITE);
        jTextArea.setFont(new Font("", Font.PLAIN, 20));


        JScrollPane jScrollPane = new RoundedJScrollPane(jTextArea);
        jScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        jScrollPane.setBackground(new Color(0,0,0,150));

        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setOpaque(false);


        add(jScrollPane);

        //func button
        Button button = new Button("b1");
        add(button);
    }
}
