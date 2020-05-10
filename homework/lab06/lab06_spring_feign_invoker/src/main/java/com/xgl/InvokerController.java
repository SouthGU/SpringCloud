package com.xgl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/21:30
 * @Description:
 */

@RestController
@Configuration
public class InvokerController {

    @Autowired
    private PersonClient personClient;

    @Autowired
    private HelloClient helloClient;

    @RequestMapping(value = "/invokeHello",method = RequestMethod.GET)
    public String invokeHello(){
       String result = personClient.hello();
        System.out.println("执行完毕"+result);
        return result;
    }

    @RequestMapping(value = "/router",method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String router(){
        Person person = personClient.getPerson(2);
        return person.getMessage();
    }

    @RequestMapping(value = "/testContract",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String testContract(){
        String springResult = helloClient.springHello();
        System.out.println("使用@RequestMapping注解的接口返回的数据："+springResult);
        String myResult = helloClient.myHello();
        System.out.println("使用@MyUrl注解的接口返回的结果："+myResult);
        return "请查看控制台输出";
    }

}
