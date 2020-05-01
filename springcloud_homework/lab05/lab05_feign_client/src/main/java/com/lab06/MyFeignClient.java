package com.lab06;

import feign.Client;
import feign.Request;
import feign.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/26/11:06
 * @Description:
 */
public class MyFeignClient implements Client {
    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        System.out.println("===========这是自定义的Feign客户端");
        try {
        //创建默认的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //获取调用的HTTP方法
        final String method = request.method();
        //创建一个HTTPRequest
        HttpRequestBase httpRequestBase = new HttpRequestBase() {
            @Override
            public String getMethod() {
                return method;
            }
        };
        //设置请求地址
        httpRequestBase.setURI(new URI(request.url()));
        //执行请求获取响应
        HttpResponse httpResponse = httpClient.execute(httpRequestBase);
        //获取响应的主题
            byte[] body = EntityUtils.toByteArray(httpResponse.getEntity());
            //将HttpClient的响应对象转换为Feign的Response
            Response response = Response.builder()
                                .body(body)
                                .headers(new HashMap<String, Collection<String>>())
                                .status(httpResponse.getStatusLine().getStatusCode())
                                .build();
            return response;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return null;
    }
}
