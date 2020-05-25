package com.xgl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/1/9:33
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class RabbitServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RabbitServerApplication.class).run(args);
    }
}
