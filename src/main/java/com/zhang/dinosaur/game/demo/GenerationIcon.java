package com.zhang.dinosaur.game.demo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class GenerationIcon {
    public static void main(String[] args) throws MalformedURLException {
        int outw = 17;
        int outh = 17;
        String inFilePath = "file:/home/orange/Downloads/download.png";
        String outFilePath = "/usr/local/zhang/learn/download.png";
        ImageIcon icon = new ImageIcon(new URL(inFilePath));
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(outw, outh, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        File output = new File(outFilePath);
        BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        icon.paintIcon(null, g, 0,0);
        g.dispose();
        try {
            ImageIO.write(bi,"png",output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
