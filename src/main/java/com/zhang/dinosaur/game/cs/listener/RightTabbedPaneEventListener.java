package com.zhang.dinosaur.game.cs.listener;

import com.zhang.dinosaur.game.cs.event.RightTabbedPaneClickAddEvent;
import com.zhang.dinosaur.game.cs.event.RightTabbedPaneClickRemoveEvent;
import com.zhang.dinosaur.game.cs.event.RightTabbedPaneClickSelectLastIndexEvent;

public interface RightTabbedPaneEventListener extends EventListener{
    public void action(RightTabbedPaneClickAddEvent e);
    public void action(RightTabbedPaneClickRemoveEvent e);
    public void action(RightTabbedPaneClickSelectLastIndexEvent e);
}
