package com.zhang.dinosaur.game.cs.listener;

import com.zhang.dinosaur.game.cs.event.*;

public interface RightTabbedPaneEventListener extends EventListener{
    /**
     * add new tab and defaultPanel event
     * @param e
     */
    public void action(RightTabbedPaneClickAddEvent e);
    /**
     * remove specify tab event
     * @param e
     */
    public void action(RightTabbedPaneClickRemoveEvent e);
    /**
     * change tab index event   record last index
     * @param e
     */
    public void action(RightTabbedPaneClickSelectLastIndexEvent e);

    /**
     * change default panel to ConnectPanel event
     * @param e
     */
    public void action(RTPChangeSelectTabDefaultPanelEvent e);
    /**
     * add new tab and ConnectPanel event
     * @param e
     */
    public void action(RTPAddTabConnectPanelEvent e);
}
