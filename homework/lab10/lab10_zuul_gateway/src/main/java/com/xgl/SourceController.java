package com.xgl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/16:08
 * @Description:
 */
@RestController
public class SourceController {
    @RequestMapping(value = "/source/hello/{name}",method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name){
        return "hello" + name;
    }
}
