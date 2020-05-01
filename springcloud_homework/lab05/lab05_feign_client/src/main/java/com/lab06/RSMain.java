package com.lab06;

import feign.Feign;
import feign.jaxrs.JAXRSContract;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/26/11:26
 * @Description:
 */
public class RSMain {
    public static void main(String[] args) {
        RSClient rsClient = Feign.builder().contract(new JAXRSContract())
                            .target(RSClient.class,"http://localhost:8080/");

        String result = rsClient.sayHelloRS();

        System.out.println("RSC-------接口响应："+result);
    }
}
