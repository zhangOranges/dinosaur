package com.zhang.dinosaur.game.cs.event;

import lombok.Data;

import javax.swing.*;

@Data
public class RightTabbedPaneClickRemoveEvent implements RightTabbedPaneClickEvent{
    private JComponent component;

    public RightTabbedPaneClickRemoveEvent(JComponent component) {
        this.component = component;
    }
}
