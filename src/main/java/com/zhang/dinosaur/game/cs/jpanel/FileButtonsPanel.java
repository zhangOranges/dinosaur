package com.zhang.dinosaur.game.cs.jpanel;

import com.zhang.dinosaur.game.cs.button.DownLoadJButton;
import com.zhang.dinosaur.game.cs.button.FreshJButton;
import com.zhang.dinosaur.game.cs.button.LevelUpJButton;
import com.zhang.dinosaur.game.cs.button.UploadJButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class FileButtonsPanel extends JPanel {
    public FileButtonsPanel() {
        super(new MigLayout("insets 0 0 0 0"));
        add(new FreshJButton());
        add(new LevelUpJButton());
        add(new DownLoadJButton());
        add(new UploadJButton());
    }
}
