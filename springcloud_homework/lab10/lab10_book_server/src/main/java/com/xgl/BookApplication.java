package com.xgl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/15:12
 * @Description:
 */
@SpringBootApplication
@RestController
public class BookApplication {

    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public String hello(@PathVariable String name){
        return "hello" + name ;
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(BookApplication.class).properties(
                "server.port=8090"
        ).run(args);
    }
}
