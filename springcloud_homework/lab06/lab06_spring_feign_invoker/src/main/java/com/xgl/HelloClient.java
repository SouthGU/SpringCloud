package com.xgl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/22:36
 * @Description:
 */

@FeignClient(name = "spring-feign-provider")
public interface HelloClient {

    @MyUrl(method = "GET",url = "/hello")
    String myHello();

    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    String springHello();
}
