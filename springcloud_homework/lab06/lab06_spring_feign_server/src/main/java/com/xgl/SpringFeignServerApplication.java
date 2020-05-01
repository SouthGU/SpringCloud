package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/21:09
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringFeignServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringFeignServerApplication.class,args);
    }
}
