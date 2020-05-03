package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/19/20:33
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class HealtherInvokerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealtherInvokerApplication.class,args);
    }
}
