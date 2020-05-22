package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;


/**
 * @Auther: sise.xgl
 * @Date: 2020/6/1/10:06
 * @Description:
 */
@SpringBootApplication
@EnableBinding(Processor.class)
public class MyReceive {
    public static void main(String[] args) {
        SpringApplication.run(MyReceive.class,args);
    }
    @StreamListener(Processor.INPUT)
    public void process1(byte[] msg){
        System.out.println("接收到的消息是processor.INPUT："+new String(msg));
    }
}
