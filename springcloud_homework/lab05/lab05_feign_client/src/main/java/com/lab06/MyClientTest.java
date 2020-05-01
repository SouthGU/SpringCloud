package com.lab06;

import com.xgl.HelloClient;
import feign.Feign;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/26/11:20
 * @Description:
 */
public class MyClientTest {
    public static void main(String[] args) {
        HelloClient helloClient = Feign.builder()
                                    .client(new MyFeignClient())
                                    .target(HelloClient.class,"http://localhost:8080/");
        String result = helloClient.sayHello();
        System.out.println("接口响应的内容："+result);
    }
}
