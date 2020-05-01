package com;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/21:20
 * @Description:
 */
public class MyConfig {

    @Bean
    public IRule getRule(){
        return new MyRule();
    }

    @Bean
    public IPing getPing(){
        return new MyPing();
    }
}
