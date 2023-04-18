package com.zhang.dinosaur.game.cs.event;

/* @program: dinosaur
 * @description: load Ip
 * @author: csy
 * @date: 2023-04-17 18:04
 **/

import com.zhang.dinosaur.game.context.LContext;

public class LoadingIpEvent  implements ConnectionSucceedEvent{
    private String Ip;

    public LoadingIpEvent(Object index){
        this.Ip = getIpFromConfig(index);
    }

    /**
     * 空参构造,初始化IP显示
     */
    public LoadingIpEvent() {
        this.Ip = LContext.getIpJLabel().getText();
    }

    /**
     * 根据配置获取ip
     * @param index
     * @return
     */
    public String getIpFromConfig(Object index){
        String ip = "-";
        if (index instanceof Integer) {
            //查找配置文件中的ip配置
        } else if (index instanceof String) {
            ip = (String) index;
        }
        StringBuilder sb = new StringBuilder();
        //拼接获取的ip地址
        sb.append(LContext.LEFT_IP_CONSTANT).append(LContext.LEFT_SPLIT).append(ip);
        return sb.toString();
    }

    public String getIp() {
        return Ip;
    }
}
