package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/11:02
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringHystrixProviderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringHystrixProviderApplication.class).properties(
                "server.port=8081"
        ).run(args);
    }
}
