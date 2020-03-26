package com;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/16/12:27
 * @Description:
 */
@RestController
public class MyController {

    @RequestMapping(value = "/person/{personId}",method = RequestMethod.GET)
    public String findName02(@PathVariable("personId") Integer personId){
        Person person = new Person(personId,"TOM",23);

        Map<String,String> paramterMap = Maps.newHashMap();
        paramterMap.put("PersonId",person.getPersonId().toString());
        paramterMap.put("Pname",person.getPname());
        paramterMap.put("Page",Integer.toString(person.getPage()));

        String str = JSON.toJSONString(paramterMap);
        return str;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
}
