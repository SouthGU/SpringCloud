package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/19/19:40
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class LAB02_HealthHandlerProvider {
    public static void main(String[] args) {
        SpringApplication.run(LAB02_HealthHandlerProvider.class,args);
    }
}
