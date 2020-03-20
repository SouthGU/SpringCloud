package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/19/13:01
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class LAB2_ServiceInvoker {
    public static void main(String[] args) {
        SpringApplication.run(LAB2_ServiceInvoker.class,args);
    }
}
