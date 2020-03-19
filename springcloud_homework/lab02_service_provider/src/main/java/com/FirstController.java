package com;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/16/12:27
 * @Description:
 */
@RestController
public class FirstController {
//    若两个方法同时开启就会找不到使用哪个方法
//    @RequestMapping(value = "/person/{name}",method = RequestMethod.GET)
//    public String findName(@PathVariable("name") String name){
//        return name;
//    }

    @RequestMapping(value = "/person/{personId}",method = RequestMethod.GET)
    public String findName02(@PathVariable("personId") Integer personId, HttpServletRequest request){
        Person person = new Person(personId,"TOM",23);

        person.setMessage(request.getRequestURI().toString());

        Map<String,String> paramterMap = Maps.newHashMap();
        paramterMap.put("PersonId",person.getPersonId().toString());
        paramterMap.put("Pname",person.getPname());
        paramterMap.put("Page",Integer.toString(person.getPage()));
        paramterMap.put("message",person.getMessage());

        String str = JSON.toJSONString(paramterMap);
        return str;
    }
}
