package com.chenyj.test.controller;

import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/11 21:25
 * 陈银杰专属测试
 */
@RestController
public class RabbitmqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMessage")
    public Result sendMessage(){
        rabbitTemplate.convertAndSend("itcast","老子天下无敌");
        return new Result(StatusCodeEnum.SUCCESS,"直接模式");
    }

    @GetMapping("/sendDirectMessage")
    public Result sendDirectMessage(){
        rabbitTemplate.convertAndSend("chenyinjie","","老子天下无敌");
        return new Result(StatusCodeEnum.SUCCESS,"分裂模式");
    }

    @GetMapping("/sendTopicMessage")
    public Result sendTopicMessage(){
        rabbitTemplate.convertAndSend("chenyinjieTopic","goods.abc.log","主题模式，老子天下无敌");
        return new Result(StatusCodeEnum.SUCCESS,"主题模式");
    }
}
