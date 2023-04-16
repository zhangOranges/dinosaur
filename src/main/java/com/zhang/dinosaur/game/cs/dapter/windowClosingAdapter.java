package com.zhang.dinosaur.game.cs.dapter;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 只为重写 windowClosing  让代码看起来整洁
 */
public class windowClosingAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        if(JOptionPane.showConfirmDialog(null,"close?","Tip",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }
}
