package com;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/22:57
 * @Description:
 */

@Configuration
public class MyAutoConfiguration {
    @Autowired(required = false)
    @MyLoadBalanced
    private List<RestTemplate> myTemplates = Collections.emptyList();

    @Bean
    public SmartInitializingSingleton smartInitializingSingleton(){
        System.out.println("==============这个Bean将在容器初始化时创建");
        return new SmartInitializingSingleton(){
            @Override
            public void afterSingletonsInstantiated() {

                    for (RestTemplate tpl:myTemplates){
                        //创建一个自定义拦截器实例
                        MyInterceptor myInterceptor = new MyInterceptor();
                        //获取原来的拦截器
                        @SuppressWarnings({"rawtypes"})
                        List list = new ArrayList(tpl.getInterceptors());
                        //将自定义拦截器添加
                        list.add(myInterceptor);
                        //将新的拦截器集合设置到RestTemplate实例
                        tpl.setInterceptors(list);
                    }
                }

        };
    }
}
