package com.xgl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/23:27
 * @Description:
 */
@RestController
public class MyController {

    @GetMapping("/normalHello")
    @ResponseBody
    public String normalHello(HttpServletRequest request){
        return "Hello lab07_World";
    }

    @GetMapping("/errorHello")
    @ResponseBody
    public String errorHello(HttpServletRequest request) throws Exception{
        Thread.sleep(10000);
        return "Error hello world ...";
    }
}
