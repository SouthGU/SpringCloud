package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/15:47
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SaleApplication3 {
    public static void main(String[] args) {
        SpringApplication.run(SaleApplication3.class,args);
    }
}
