package com.chenyj.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import util.IdWorker;
import util.JwtUtil;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/20 0:24
 * 陈银杰专属测试
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@CrossOrigin
@EnableDiscoveryClient
public class FriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendApplication.class, args);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
