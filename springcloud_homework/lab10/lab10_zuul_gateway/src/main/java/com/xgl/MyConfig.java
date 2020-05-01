package com.xgl;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/16:16
 * @Description:
 */
@Configuration
public class MyConfig {

    @Bean
    public PatternServiceRouteMapper patternServiceRouteMapper(){
        return new PatternServiceRouteMapper(
                "(zuul)-(?<module>.+)-(service)",
                "${module}/**"
        );
    }
}
