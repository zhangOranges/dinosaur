package com.zhang.dinosaur.game.cs.jpanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static javax.swing.JFileChooser.FILES_ONLY;

public class RenZhengJPanel extends JPanel {

    private final JLabel siyaoLable = new JLabel("私钥");
    private final JTextField siyao = new JTextField();
    private final JButton lookup = new JButton("浏览");

    private final JLabel passwordLabel = new JLabel("密码");
    private final JPasswordField passwordField = new JPasswordField();
    private final String[] methodStr = {"密码", "公钥"};
    private final JComboBox methodList = new JComboBox(methodStr);
    private boolean state = false;
    /**
     * 认证 布局
     */
    public RenZhengJPanel() {

        super(new MigLayout("left,insets 20 30 0 0"));
        //文本框的最小宽度
        String textMWidth = "wmin 200";
        JTextField value = new JTextField();

        setBorder(BorderFactory.createTitledBorder("认证"));


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

        lookup.addActionListener(e->{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(FILES_ONLY);
            fileChooser.showOpenDialog(null);
            File selectedFile = fileChooser.getSelectedFile();
            String fileAbsolutePath = selectedFile.getAbsolutePath();
            //todo 使用文件做后续的操作
        });
    }

    //监听下拉改变事件
    private ActionListener getJCActionListener() {

        return e -> {
            JComboBox source = (JComboBox) e.getSource();
            String selectedItem = (String) source.getSelectedItem();
            if (methodStr[1].equals(selectedItem)) {
                changeEditable();
            } else {
                changeEditable();
            }
        };
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
