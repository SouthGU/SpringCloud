package com.xgl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/15:37
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class BookApplication2 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BookApplication2.class).properties(
                "server.port=9000"
        ).run(args);
    }
}
