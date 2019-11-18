package com.chenyj.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/18 23:21
 * 陈银杰专属测试
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka8761Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka8761Application.class, args);
    }
}
