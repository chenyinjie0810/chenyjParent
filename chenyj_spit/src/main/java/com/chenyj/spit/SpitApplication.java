package com.chenyj.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/28 23:28
 * 陈银杰专属测试
 */
@SpringBootApplication
public class SpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
