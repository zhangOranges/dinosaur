package com.zhang.dinosaur.game.cs.button;

import javax.swing.*;
import java.awt.*;

public class CsJButton extends JButton {
    public CsJButton(String name) {
        super(name);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setMargin(new Insets(0,0,0,0));
    }
}
