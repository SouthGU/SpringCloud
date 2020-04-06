package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/21:06
 * @Description:
 */

@SpringBootApplication
@EnableEurekaClient
public class CloudProviderApplication {
    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(CloudProviderApplication.class)
                .properties("server.port="+port).run(args);
    }
}
