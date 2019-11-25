package com.chenyj.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/25 23:00
 * 陈银杰专属测试
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class WebAppliction {
    public static void main(String[] args) {
        SpringApplication.run(WebAppliction.class, args);
    }
}
