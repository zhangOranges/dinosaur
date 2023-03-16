package com.zhang.dinosaur.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("base64")
@Slf4j
public class Base64Controller {

    /**
     * base64转图片
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
                outputStream.write("base64参数不能为空".getBytes());
                outputStream.flush();
                return;
            }
            byte[] img = Base64.decode(base64.getBytes());
            response.setHeader("content-type","image/png");
            outputStream.write(img);
            outputStream.flush();
        }catch (Exception e){
            log.error("{}",e);
            if (outputStream != null){
                try {
                    outputStream.write("toImg方法异常".getBytes());
                    outputStream.flush();
                }catch (IOException e1){
                    log.error("{}",e1);
                }

            }

        }


    }
}
