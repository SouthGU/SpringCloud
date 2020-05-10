package com.xgl;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/22:44
 * @Description:
 */
@Configuration
public class MyConfig {
    @Bean
    public Contract feignContract(){
        return new MyContract();
    }
}
