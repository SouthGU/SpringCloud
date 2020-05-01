package com.xgl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/21:30
 * @Description:
 */
@FeignClient("spring-feign-provider-2") //声明调用的服务名称
public interface PersonClient {

    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    String hello();

    @RequestMapping(method = RequestMethod.GET,value = "/person/{personId}")
    Person getPerson(@PathVariable("personId") Integer personId);
}
