package com.xgl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/12:47
 * @Description:
 */
@FeignClient(name = "spring-hystrix-provider",fallback = HelloClient.HelloClientFallback.class)
public interface HelloClient {

    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    public String hello();

    @Component
    static class HelloClientFallback implements HelloClient{
        public String hello(){
            return "error hello";
        }
    }
}
