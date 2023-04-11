package com.zhang.dinosaur.game.cs.jframe;

import com.zhang.dinosaur.game.context.GContext;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 加载界面
 */

public class LoadingFrame extends JFrame {
    private JLabel context = new JLabel("loading");
    public LoadingFrame(){
        super("loading view");
        {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setSize(400, 200);
            setLocationRelativeTo(null);
        }

        context.setFont(new Font("verdana", Font.BOLD, 24));

        JPanel panel = new JPanel(new MigLayout("align 50% 50%"));
        panel.add(context);
        panel.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK));
        setContentPane(panel);
        setVisible(true);
    }

    public void loading(){
        //后期处理这里加载配置信息
        GContext.loadConfig();
        context.setText("loding done");
        setVisible(false);
    }
}
