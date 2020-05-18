package com.xgl;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/16:59
 * @Description:
 */
@Configuration
public class FilterConfig {

    @Bean
    public RestTemplateFilter restTemplateFilter(RestTemplate restTemplateFilter){
        return new RestTemplateFilter(restTemplateFilter);
    }

    @Bean
    public ExceptionFilter exceptionFilter(){
        return  new ExceptionFilter();
    }

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
