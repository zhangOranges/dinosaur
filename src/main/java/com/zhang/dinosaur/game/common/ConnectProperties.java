package com.zhang.dinosaur.game.common;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * real connect properties
 */
@Data
@Accessors(chain = true)
@ToString
public class ConnectProperties{
    /**
     *  connect alias   As nickname
     */
    private String alias;
    /**
     * ip 127.0.0.1 etc
     */
    private String host;
    /**
     * port 80 etc
     */
    private String port;
    /**
     *  user name
     */
    private String uname;
    /**
     * password type   public key / password etc
     */
    private int passwordType;
    /**
     *  password
     */
    private String passwd;
    /**
     * if key to login save base64 Code
     */
    private String base64PublicKey;
}
