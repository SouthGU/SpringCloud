package com.xgl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/15:10
 * @Description:
 */
@EnableZuulProxy
@SpringBootApplication
public class FirstRouterApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FirstRouterApplication.class).properties(
                "server.port=8081"
        ).run(args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
