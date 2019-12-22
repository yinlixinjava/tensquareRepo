package com.tensquare.sms.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @RabbitHandler
    public void getMsg(Map<String, String> map){
        //{mobile=13269755570, checkcode=666542}
        System.out.println("手机号为："+map.get("mobile"));
        System.out.println("验证码为："+map.get("checkcode"));
    }

}