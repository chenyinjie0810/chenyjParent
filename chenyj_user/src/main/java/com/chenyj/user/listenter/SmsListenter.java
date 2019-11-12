package com.chenyj.user.listenter;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/13 0:18
 * 陈银杰专属测试
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListenter {

    @RabbitHandler
    public void executerSms(Map<String,String> map){
        System.out.println(map);
    }
}
