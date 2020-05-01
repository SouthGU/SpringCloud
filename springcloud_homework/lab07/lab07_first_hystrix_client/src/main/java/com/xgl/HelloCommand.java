package com.xgl;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/23:32
 * @Description:
 */
public class HelloCommand  extends HystrixCommand<String> {
    private String url;
    CloseableHttpClient closeableHttpClient;
    public HelloCommand(String url){
        //调用父类构造方法，设置命令组的key，默认用来作为线程池的key
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.closeableHttpClient = HttpClients.createDefault();
        this.url = url;
    }

    @Override
    protected String run() throws Exception {
        try {
            HttpGet httpGet = new HttpGet(url);
            //获取服务响应
            HttpResponse response = closeableHttpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected String getFallback(){
        System.out.println(" 执行HelloCommad的回退方法");
        return "error;";
    }
}
