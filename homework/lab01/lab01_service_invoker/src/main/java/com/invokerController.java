package com;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/16/12:46
 * @Description:
 */
@RestController
@Configuration
public class invokerController {

    @Bean
    //开启负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/router",method = RequestMethod.GET)
    public String router(){
        RestTemplate restTemplate = getRestTemplate();
        String s = restTemplate.getForObject("http://first-service-provider/person/9001", String.class);
        return s;
    }

}
