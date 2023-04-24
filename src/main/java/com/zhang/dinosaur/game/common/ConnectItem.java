package com.zhang.dinosaur.game.common;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.swing.*;

/**
 * only show
 */
@Data
@Accessors(chain = true)
public class ConnectItem{
    private String alias;
    private String host;
    private String port;
    private String uname;

    @Override
    public String toString() {
        return
                alias
                +"      "+host
                +"      "+port
                +"      "+uname
                +"      "
                ;
    }
}
