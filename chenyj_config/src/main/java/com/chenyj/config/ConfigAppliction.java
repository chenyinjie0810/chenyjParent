package com.chenyj.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/27 23:31
 * 陈银杰专属测试
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigAppliction {
    public static void main(String[] args) {
        SpringApplication.run(ConfigAppliction.class, args);
    }
}
