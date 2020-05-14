package com.xgl;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/23:43
 * @Description:
 */
public class HelloErrorCommand {
    public static void main(String[] args) {
        String normalUrl = "http://localhost:8080/errorHello";
        HelloCommand command = new HelloCommand(normalUrl);
        String result = command.execute();
        System.out.println("请求异常的服务，结果："+result);
    }
}
