package com.chenyj.test.rabbitmqcustomer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/11 21:35
 * 陈银杰专属测试
 */
@Component
@RabbitListener(queues = "itheima")
public class CustomerItheima {

    @RabbitHandler
    public void getMsg(String message){
        System.out.println("itheima"+message);
    }

}
