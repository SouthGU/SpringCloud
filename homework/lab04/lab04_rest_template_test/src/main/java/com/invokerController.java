package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/23:03
 * @Description:
 */

@RestController
@Configuration
public class invokerController {

    @Bean
    @MyLoadBalanced
    public RestTemplate getMyRestTemplate(){
        return new RestTemplate();
    }
    @RequestMapping(value = "/router",method = RequestMethod.GET)
    public String router(){
        RestTemplate restTpl = getMyRestTemplate();
        String json = restTpl.getForObject("http://my-server/hello",String.class);
        return json;
    }

    //最终的请求都会转发到这个服务
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello World";
    }

}
