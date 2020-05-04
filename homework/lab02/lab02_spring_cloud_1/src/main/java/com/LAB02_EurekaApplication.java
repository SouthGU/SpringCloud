package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/19/11:24
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class LAB02_EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(LAB02_EurekaApplication.class,args);
    }
}
