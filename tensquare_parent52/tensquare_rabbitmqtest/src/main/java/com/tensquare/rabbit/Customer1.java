package com.tensquare.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class Customer1 {

    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("itcast："+msg);
    }
}
