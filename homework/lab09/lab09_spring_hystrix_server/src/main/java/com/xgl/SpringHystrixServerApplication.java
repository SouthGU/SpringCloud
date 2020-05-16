package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/10:57
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringHystrixServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringHystrixServerApplication.class,args);
    }
}
