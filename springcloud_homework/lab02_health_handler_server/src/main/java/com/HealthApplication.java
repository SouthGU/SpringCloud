package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/19/20:15
 * @Description:
 */

@SpringBootApplication
@EnableEurekaServer
public class HealthApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthApplication.class,args);
    }
}
