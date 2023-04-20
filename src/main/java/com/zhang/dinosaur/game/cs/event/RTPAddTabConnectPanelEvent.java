package com.zhang.dinosaur.game.cs.event;

import com.zhang.dinosaur.game.common.ConnectProperties;
import lombok.Data;

@Data
public class RTPAddTabConnectPanelEvent implements EventObject{
    private ConnectProperties connectProperties;

    public RTPAddTabConnectPanelEvent(ConnectProperties connectProperties) {
        this.connectProperties = connectProperties;
    }
}
