package com.xgl;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/16:41
 * @Description:
 */
@Configuration
public class FallbackConfig {

    @Bean
    public FallbackProvider saleFallbackProvider(){
        return new MyFallbackProvider();
    }

}
