package com.xgl;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/13:00
 * @Description:
 */
public class TestFeignClient {
    public static void main(String[] args) throws InterruptedException {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger logger = loggerContext.getLogger("root");
        logger.setLevel(Level.toLevel("INFO"));

        final CloseableHttpClient httpClient = HttpClients.createDefault();
        for (int i = 0 ; i < 6 ; i ++ ){
            Thread t = new Thread(){
                @Override
                public void run() {
                    try{
                        String url = "http://localhost:9000/feign/hello";
                        HttpGet httpGet = new HttpGet(url);
                        HttpResponse response = httpClient.execute(httpGet);
                        System.out.println(EntityUtils.toString(response.getEntity()));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        Thread.sleep(15000);
    }
}
