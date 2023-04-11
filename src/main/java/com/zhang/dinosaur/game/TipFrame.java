package com.zhang.dinosaur.game;

import cn.hutool.core.util.StrUtil;
import com.zhang.dinosaur.common.ThreadUtils;
import net.miginfocom.swing.MigLayout;
import org.apache.commons.codec.binary.StringUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 提示界面
 */
public class TipFrame extends JFrame {
    public TipFrame(String msg){
        super("TipFrame view");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);

        JPanel jPanel = new JPanel(new MigLayout("align 50% 50%"));
        jPanel.add(new JLabel("msg"));
        add(jPanel);
        setLocationRelativeTo(null);
        ThreadUtils.sleep(100);
        setVisible(true);
    }
}
