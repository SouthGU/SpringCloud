package com.xgl;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/23:32
 * @Description:
 */
public class HelloMain {
    public static void main(String[] args) {
        String normalUrl = "http://localhost:8080/normalHello";
        HelloCommand command = new HelloCommand(normalUrl);
        String result = command.execute();
        System.out.println("请求正常的服务，结果："+result);
    }
}
