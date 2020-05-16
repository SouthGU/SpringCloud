package com.xgl;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/12:54
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    HelloClient helloClient;

    @RequestMapping(value = "/feign/hello",method = RequestMethod.GET)
    public String feignHello(){
        String helloResult = helloClient.hello();

        HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory
                                        .getInstance(HystrixCommandKey.Factory
                                                .asKey("HelloClient#hello()"));
        System.out.println("断路器的状态："+breaker.isOpen());
        return helloResult;
    }
}
