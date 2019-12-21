package com.tensquare.test;

import com.tensquare.rabbit.RabbitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 13269755565 on 2019/12/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

   /* @Test
    public void sendMsg1() {
        rabbitTemplate.convertAndSend("itcast", "直接模式测试");
    }*/

    /*@Test
    public void sendMsg2() {
        rabbitTemplate.convertAndSend("chuanzhi", "", "分裂模式模式测试");
    }*/

    @Test
    public void sendMsg3() {
        rabbitTemplate.convertAndSend("yinlixinRabbit", "good.log", "主题分裂模式模式测试");
    }

}
