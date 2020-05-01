package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/1/9:43
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableBinding(SendService.class)
@EnableBinding(value = {SendService.class, Processor.class})
@EnableFeignClients
@EnableZuulProxy
public class RabbitProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class,args);
    }
}
