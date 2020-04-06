package com;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/22:53
 * @Description:
 */
public class MyInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        System.out.println("====================这是自定义拦截器");
        System.out.println("====================原来的URI:"+request.getURI());

        //换成新的请求对象
        MyHttpRequest newRequest = new MyHttpRequest(request);
        System.out.println("拦截后的新URI:"+newRequest.getURI());
        return execution.execute(newRequest,body);
    }
}
