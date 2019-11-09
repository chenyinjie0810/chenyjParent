package com.chenyj.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/8 23:42
 * 陈银杰专属测试
 */
@SpringBootApplication
public class SearchApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
