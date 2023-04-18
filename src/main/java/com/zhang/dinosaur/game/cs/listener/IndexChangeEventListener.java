package com.zhang.dinosaur.game.cs.listener;


import com.zhang.dinosaur.game.cs.event.IndexChangeEvent;

public interface IndexChangeEventListener extends EventListener{

    public void action(IndexChangeEvent o);
}
