package com.xgl;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/21:10
 * @Description:
 */
@RestController
public class FirstController {

    @RequestMapping(value = "/person/{personId}",method = RequestMethod.GET)
    public Person findPerson(@PathVariable("personId") Integer personId, HttpServletRequest request){
        Person person = new Person(personId,"TOMMY",30);

        person.setMessage(request.getRequestURI().toString());
        return person;
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "Hello World";
    }

}
