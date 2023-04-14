package com.zhang.dinosaur.game.cs.event;

import lombok.Data;

import java.util.function.Function;

@Data
public class ShowTextAddContentEvent implements EventObject {

    private String text;
    public ShowTextAddContentEvent(String text, Function<String,String> function) {
        this.text = text;
        if (function != null){
            this.text = function.apply(text);
        }
    }

}
