package com.xgl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/21/10:51
 * @Description:
 */
@RestController
public class MyController {

    @RequestMapping(value = "/person/{personId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId,
                             HttpServletRequest request){
            Person p = new Person();
            p.setId(personId);
            p.setName("tommy");
            p.setAge(30);
            p.setMessage(request.getRequestURI().toString());
            return p;
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "Hello Spring Cloud";
    }

    @RequestMapping(value = "/person/create",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String createPerson(@RequestBody Person person){
        System.out.println(person.getName()+"-"+person.getAge());
        return "SUCCESS,Person Id:"+person.getId();
    }

    @RequestMapping(value = "/person/createXML",method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_XML_VALUE,
                    produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String createXMLPerson(@RequestBody Person person){
        System.out.println(person.getName()+"-"+person.getId());
        return "<result><message>success</message></result>";
    }

}
