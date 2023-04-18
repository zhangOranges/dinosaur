package com.zhang.dinosaur.game.cs.dapter;

import com.zhang.dinosaur.game.cs.jframe.ShowConnectListJFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OpenFolderMouseAdapter extends MouseAdapter {
    private JTabbedPane jTabbedPane;
    public OpenFolderMouseAdapter(JTabbedPane jTabbedPane) {
        super();
        this.jTabbedPane = jTabbedPane;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && jTabbedPane.getSelectedIndex() == 0) {
            jTabbedPane.setSelectedIndex(-1);
            JFrame jFrame = new ShowConnectListJFrame();
            jFrame.setVisible(true);
        }else{
            super.mouseClicked(e);
        }
    }
}
