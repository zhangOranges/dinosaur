package com.zhang.dinosaur.game.cs.event;

import com.zhang.dinosaur.game.common.ConnectProperties;
import lombok.Data;


@Data
public class RTPChangeSelectTabDefaultPanelEvent implements EventObject {

    public RTPChangeSelectTabDefaultPanelEvent(String title, ConnectProperties connectProperties) {
        this.title = title;
        this.connectProperties = connectProperties;
    }

    private String title;
    private ConnectProperties connectProperties;

}
