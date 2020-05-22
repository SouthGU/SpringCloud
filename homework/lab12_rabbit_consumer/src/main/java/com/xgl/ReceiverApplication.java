package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/1/9:54
 * @Description:
 */
@SpringBootApplication
@EnableBinding(ReceiveService.class)
public class ReceiverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReceiverApplication.class,args);
    }

    @StreamListener("myInput")
    public void receive(byte[] msg){
        System.out.println("接收到的消息："+ new String(msg));
    }


    //监听binding中的消息
    @StreamListener("myinput2")
    public void input(byte[] msg) {
        System.out.println("Zuul-gateway获取到消息: "+ new String(msg));
    }

}
