package com.zhang.dinosaur.game.context;

/* @program: dinosaur
 * @description: 左侧布局上下文
 * @author: csy
 * @date: 2023-04-17 10:04
 **/

import javax.swing.*;
import java.awt.*;

public class LContext {
    public static final String LEFT_SYNC = "同步状态";
    public static final String LEFT_IP = "IP  -";
    public static final String LEFT_IP_CONSTANT = "IP";
    public static final String LEFT_SYSTEM_INFO = "系统信息";
    public static final String LEFT_RUN_INFO = "运行  -";
    public static final String LEFT_LOAD_INFO = "负载  -";
    public static final String LEFT_CPU_INFO = "CPU";
    public static final String LEFT_MEN_INFO = "内存";
    public static final String LEFT_EXG_INFO = "交换";
    public static final String LEFT_SPLIT = "  ";

    /**
     * 同步状态
     * @return
     */
    public static JLabel getSyncJLabel(){
        return getJLabel(LContext.LEFT_SYNC);
    }

    /**
     * 获取IP的JLabel
     * @return
     */
    public static JLabel getIpJLabel(){
        return getJLabel(LContext.LEFT_IP);
    }

    public static JLabel getRunJLabel(){
        return getJLabel(LContext.LEFT_RUN_INFO);
    }

    public static JLabel getLoadJLabel(){
        return getJLabel(LContext.LEFT_LOAD_INFO);
    }

    public static JLabel getCpuJLabel(){
        return getJLabel(LContext.LEFT_CPU_INFO);
    }

    public static JLabel getMemJLabel(){
        return getJLabel(LContext.LEFT_MEN_INFO);
    }

    public static JLabel getExgJLabel(){
        return getJLabel(LContext.LEFT_EXG_INFO);
    }

    public static JLabel getSystemLabel(){
        JLabel jLabel = new JLabel(LEFT_SYSTEM_INFO,SwingConstants.CENTER);
        jLabel.setFont(new Font("verdana", Font.BOLD, 12));
        return jLabel;
    }

    /**
     * 获取某一个JLabel
     * @param label
     * @return
     */
    private static JLabel getJLabel(String label){
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("verdana", Font.PLAIN, 12));
        return jLabel;
    }
}
