package com.xgl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/11:01
 * @Description:
 */
@RestController
public class PersonController {

    @RequestMapping(value = "/person/{personId}",method = RequestMethod.GET
                    ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId, HttpServletRequest request){
        Person person = new Person(personId,"TOMMY",30);

        person.setMessage(request.getRequestURI().toString());
        return person;
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() throws InterruptedException {
        Thread.sleep(800);
        return "Hello World";
    }

}
