package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/26/10:37
 * @Description:
 */
@SpringBootApplication
public class FirstRibbonServerApplication {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();

        new SpringApplicationBuilder(FirstRibbonServerApplication.class)
                .properties("server.port="+port).run(args);
    }
}
