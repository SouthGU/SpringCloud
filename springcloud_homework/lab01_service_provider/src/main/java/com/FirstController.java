package com;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/16/12:27
 * @Description:
 */
@RestController
public class FirstController {

    @RequestMapping(value = "/person/{name}",method = RequestMethod.GET)
    public String findName(@PathVariable("name") String name){
        return name;
    }
}
