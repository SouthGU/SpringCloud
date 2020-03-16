package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/16/12:45
 * @Description:
 */

@SpringBootApplication
@EnableEurekaClient
public class FirstInvoker {
    public static void main(String[] args) {
        SpringApplication.run(FirstInvoker.class,args);
    }
}
