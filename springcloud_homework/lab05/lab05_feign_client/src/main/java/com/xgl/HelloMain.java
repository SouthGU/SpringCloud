package com.xgl;

import feign.Feign;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/25/9:27
 * @Description:
 */
public class HelloMain {
    public static void main(String[] args) {

        HelloClient helloClient = Feign.builder().target(HelloClient.class,"http://localhost:8080/");
        System.out.println(helloClient.sayHello());
    }
}
