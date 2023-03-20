package com.zhang.dinosaur.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("base64")
@Slf4j
public class Base64Controller {

    /**
     * base64 to img
     * @param base64
     * @param response
     */
    @PostMapping(value = "toImg")
    public void toImg(String base64, HttpServletResponse response){
        ServletOutputStream outputStream = null;
        try {
            response.setHeader("content-type","text/html");
            outputStream = response.getOutputStream();
            if (StrUtil.isBlank(base64)){
                outputStream.write("base64 param not null".getBytes());
                outputStream.flush();
                return;
            }
            byte[] img = Base64.decode(base64.getBytes());
            response.setHeader("content-type","image/png");
            response.setHeader("sj", LocalDateTime.now().toString());
            outputStream.write(img);
            outputStream.flush();
        }catch (Exception e){
            log.error("{}",e);
            if (outputStream != null){
                try {
                    outputStream.write("toImg function exception".getBytes());
                    outputStream.flush();
                }catch (IOException e1){
                    log.error("{}",e1);
                }

            }

        }


    }
}
