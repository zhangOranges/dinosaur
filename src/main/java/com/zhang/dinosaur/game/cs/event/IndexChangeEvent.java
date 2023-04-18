package com.zhang.dinosaur.game.cs.event;

import lombok.Data;

@Data
public class IndexChangeEvent implements EventObject{
    private int curIndex;

    public IndexChangeEvent(int curIndex) {
        this.curIndex = curIndex;
    }
}
