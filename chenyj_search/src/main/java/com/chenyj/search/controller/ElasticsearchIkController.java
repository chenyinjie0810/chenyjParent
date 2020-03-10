package com.chenyj.search.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resources;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author chenyj
 * @Description 自定义分词类
 * @Date create by 2020/3/10 0010
 * 陈银杰专属测试
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/elasticsearchIk")
@Slf4j
public class ElasticsearchIkController {

    /**
     * @desc: 远程自定义分词
     * @author: chenyj
     * @date:  2020/3/10 0010
     * @param response
     */
    @GetMapping("")
    public void getIk(HttpServletResponse response) {
        InputStream inputStream=null;
        BufferedReader bufferedReader = null;
        try {
            log.info("elasticsearch调用远程自定义分词器");
            StringBuffer value = new StringBuffer();
//            inputStream = Resources.class.getResourceAsStream("/banner.txt");
            inputStream=this.getClass().getResourceAsStream("/banner.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String a;
            while ((a = bufferedReader.readLine()) != null) {
                value.append(a + "\n");
            }
            response.setHeader("Last-Modified", String.valueOf(System.currentTimeMillis()));
            response.setHeader("ETag", String.valueOf(System.currentTimeMillis()));
            response.setContentType("text/plain; charset=utf-8");
            response.getWriter().write(value.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
