package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/16:25
 * @Description:
 */

@SpringBootApplication
@EnableEurekaServer
public class lab04_CloudServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(lab04_CloudServerApplication.class,args);
    }
}
