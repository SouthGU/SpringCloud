package com.xgl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/15:53
 * @Description:
 */
@EnableZuulProxy
@SpringBootApplication
public class GateWayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(GateWayApplication.class).properties(
                "server.port=8081"
        ).run(args);
    }
}
