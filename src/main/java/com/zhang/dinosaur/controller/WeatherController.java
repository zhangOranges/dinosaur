package com.zhang.dinosaur.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController {

    /**
     * get weather interface
     * @return
     */
    @GetMapping("getWeather")
    public String getWeather(){
        String url = "http://www.weather.com.cn/data/sk/101090101.html";
        String s = HttpUtil.get(url);
        ObjectMapper o = new ObjectMapper(s);
        JSONObject jsonObject = new JSONObject();
        o.map(jsonObject,null);
        jsonObject.putByPath("weatherinfo.city","***");
        jsonObject.putByPath("weatherinfo.cityid","***");
        return jsonObject.toString();

    }
}
