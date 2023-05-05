package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenZhengJPanel extends JPanel {

    private JLabel siyaoLable = new JLabel("私钥");
    private JTextField siyao = new JTextField();
    private JButton lookup = new JButton("浏览");

    private JLabel passwordLabel = new JLabel("密码");
    private JPasswordField passwordField = new JPasswordField();
    private String[] methodStr = {"密码", "公钥"};

    private boolean state = false;

    public RenZhengJPanel() {

        super(new MigLayout("left,insets 20 30 0 0"));
        //文本框的最小宽度
        String textMWidth = "wmin 200";
        JTextField value = new JTextField();

        setBorder(BorderFactory.createTitledBorder("认证"));


        JComboBox methodList = new JComboBox(methodStr);
        methodList.addActionListener(getJCActionListener());
        JLabel name = new JLabel("方法");

        add(name);
        add(methodList, "wrap," + textMWidth);

        name = new JLabel("用户名");
        value = new JTextField();
        add(name);
        add(value, "wrap," + textMWidth);


        add(passwordLabel);
        add(passwordField, "wrap," + textMWidth);

        //私钥
        siyao.setEditable(state);
        siyaoLable.setEnabled(state);
        add(siyaoLable);
        add(siyao, textMWidth);

        lookup.setEnabled(state);
        add(lookup);

    }

    //监听下拉改变事件
    private ActionListener getJCActionListener() {
        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                String selectedItem = (String) source.getSelectedItem();
                if (methodStr[1].equals(selectedItem)) {
                    changeEditable();
                } else {
                    changeEditable();
                }
            }
        };

        return ac;
    }

    //改变文本框是否可编辑
    private void changeEditable() {
        state = !state;
        siyao.setEditable(state);
        siyaoLable.setEnabled(state);
        lookup.setEnabled(state);
        passwordField.setEnabled(!state);
        passwordLabel.setEnabled(!state);
    }
}
