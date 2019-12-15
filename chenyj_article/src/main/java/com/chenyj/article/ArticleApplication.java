package com.chenyj.article;
import com.chenyj.article.aop.SysLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;
import util.IdWorker;

/**
 * @desc: 
 * @author: chenyj
 * @date: 2019/11/19
 */
@SpringBootApplication
@EnableCaching
@EnableEurekaClient
@EnableAspectJAutoProxy
public class ArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


}
