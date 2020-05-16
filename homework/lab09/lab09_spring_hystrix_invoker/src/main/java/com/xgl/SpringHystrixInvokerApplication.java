package com.xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/11:20
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@ServletComponentScan
@EnableFeignClients
public class SpringHystrixInvokerApplication {

    @LoadBalanced
    @Bean
    public RestTemplate getrestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringHystrixInvokerApplication.class,args);
    }
}
