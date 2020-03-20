package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/16/12:00
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class FirstServer {
    public static void main(String[] args) {
        SpringApplication.run(FirstServer.class,args);
    }
}
