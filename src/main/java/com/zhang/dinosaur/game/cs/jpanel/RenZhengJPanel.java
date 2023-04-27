package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class RenZhengJPanel extends JPanel {
    public RenZhengJPanel() {

        super(new MigLayout("left,insets 20 30 0 0"));
        setBorder(BorderFactory.createTitledBorder("认证"));
        JLabel name = new JLabel("方法");
        JTextField value = new JTextField();
        add(name);
        add(value,"wrap");

        name = new JLabel("用户名");
        value = new JTextField();
        add(name);
        add(value,"wrap");

        name = new JLabel("密码");
        value = new JPasswordField();
        add(name);
        add(value,"wrap");

        name = new JLabel("私钥");
        value = new JTextField();
        add(name);
        add(value);

        JButton lookup = new JButton("浏览");
        add(lookup);

    }
}
