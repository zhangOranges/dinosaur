package com.zhang.dinosaur.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oshi.SystemInfo;

@RestController
@RequestMapping("sysInfo")
public class SysInfoController {


    /**
     * out device info
     * @return
     */
    @GetMapping("getSysInfo")
    public String getSysInfo(){
        SystemInfo systemInfo = new SystemInfo();
        ObjectMapper objectMapper = new ObjectMapper();
        String to = null;
        try {
            to = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(systemInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return to;
    }
}
