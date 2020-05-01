package com.xgl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/21:10
 * @Description:
 */

@SpringBootApplication
@EnableEurekaClient
public class SpringFeignProviderApplication {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(SpringFeignProviderApplication.class).properties(
                "server.port="+port).run(args);

    }
}
