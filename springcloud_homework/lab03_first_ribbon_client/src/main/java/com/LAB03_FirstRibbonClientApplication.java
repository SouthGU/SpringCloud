package com;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/26/10:50
 * @Description:
 */
@SuppressWarnings("depercation")
public class LAB03_FirstRibbonClientApplication {

    public static void main(String[] args) throws Exception {

        //设置请求服务器
        ConfigurationManager.getConfigInstance().setProperty(
                "my-client.ribbon.listOfServers",
                "localhost:8081,localhost:8085"
        );

        // 获取REST客户端及穿件请求实例
        RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
        HttpRequest request = HttpRequest.newBuilder().uri("/person/1").build();

        for (int i = 0 ; i < 6 ; i++ ){
            HttpResponse response  = client.executeWithLoadBalancer(request);
            String result = response.getEntity(String.class);
            System.out.println(result);
        }
    }
}
