package com.xgl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/1/9:44
 * @Description:
 */
@RestController
public class ProducerController {

    @Autowired
    SendService sendService;

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String sendRequest(){
        Message msg = MessageBuilder.withPayload("Hello RabbitMQ生产者发送消息-->".getBytes()).build();
        sendService.sendOrder().send(msg);
        return "SUCCESS";
    }

    @Resource
    PersonClient personClient;

    @RequestMapping(value = "/send/{uid}",method = RequestMethod.GET)
    public String sendRequest_2(@PathVariable(value = "uid") String uid){
        System.out.println(uid);
        User p = personClient.getPerson(uid);
        String info = p.getUid()+"  "+p.getUsername();
        Message msg = MessageBuilder.withPayload(info.getBytes()).build();
        sendService.sendOrder().send(msg);
        return "SUCCESS";
    }
}
