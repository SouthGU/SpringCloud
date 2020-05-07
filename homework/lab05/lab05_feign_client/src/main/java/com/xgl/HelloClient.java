package com.xgl;

import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/25/9:17
 * @Description:
 */
public interface HelloClient {

    @RequestLine("GET /hello")
    String sayHello();
}
