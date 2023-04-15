package com.zhang.dinosaur.game.cs.event;

import lombok.Data;

@Data
public class TreeClickedEvent implements EventObject{
    private String path;

    public TreeClickedEvent(String path) {
        this.path = path;
    }
}
