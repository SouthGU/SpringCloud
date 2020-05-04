package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/19/12:00
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class LAB02_ServiceProvider {
    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(LAB02_ServiceProvider.class)
                .properties("server.port="+port).run(args);


    }
}
