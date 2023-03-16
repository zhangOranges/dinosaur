package com.zhang.dinosaur.controller;

import cn.hutool.core.io.FileUtil;
import com.zhang.dinosaur.common.NetPrintStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ImageBanner;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintStream;

@RestController
@RequestMapping("banner")
@Slf4j
public class BannerController {

    /**
     * 图片转ascii
     * @param file
     * @param response
     */
    @PostMapping("imgToAscii")
    public void imgToAscii(MultipartFile file,HttpServletResponse response){
        try {
            byte[] bytes = file.getBytes();
            ServletOutputStream outputStream = response.getOutputStream();
            Resource resource = new ByteArrayResource(bytes);
            ImageBanner imageBanner = new ImageBanner(resource);
            Environment environment = new StandardEnvironment();
            PrintStream netPrintStream = new NetPrintStream(outputStream);
            imageBanner.printBanner(environment,null,netPrintStream);
        }catch (Exception e){
            log.error("{}",e);
        }


    }
}
