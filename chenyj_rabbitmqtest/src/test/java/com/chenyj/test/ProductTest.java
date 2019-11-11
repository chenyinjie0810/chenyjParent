package com.chenyj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/11 21:11
 * 陈银杰专属测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqAppliction.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        rabbitTemplate.convertAndSend("itcast","老子天下无敌");
    }

}
