package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/21:29
 * @Description:
 */

@SpringBootApplication
@EnableEurekaClient
public class CloudInvokerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudInvokerApplication.class,args);
    }
}
