package com.zhang.dinosaur.game.cs.jpanel;

import javax.swing.*;
import java.awt.*;

public class CsJSplitPane extends JSplitPane {
    public CsJSplitPane(int newOrientation, boolean newContinuousLayout, Component newLeftComponent, Component newRightComponent) {
        super(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent);
        setOneTouchExpandable(true);
        setContinuousLayout(true);
        setDividerSize(1);
        setDividerLocation(150);
        setOpaque(false);
        setBorder(null);
    }
}
