package com.xgl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/11:20
 * @Description:
 */

@RestController
@Configuration
public class InvokerController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/router/{personId}",method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person router(@PathVariable Integer personId){
        Person person = personService.getPerson(personId);
        return person;
    }

    @RequestMapping(value = "/testConfig",method = RequestMethod.GET)
    public String testConfig(){
        String result = personService.testConfig();
        return result;
    }

    @RequestMapping(value = "/testException",method = RequestMethod.GET)
    public String testException() throws MyException {
        String result = personService.testException();
        return result;
    }


    @Autowired
    private CacheService cacheService;
    @RequestMapping(value = "/cache1/{personId}",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person testCacheResult(@PathVariable Integer personId){
        for(int i=0;i<3;i++){
            Person p = cacheService.getPerson(personId);
            System.out.println("控制器调用服务："+i);
        }
        return new Person();
    }

    @RequestMapping(value = "/cache2",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String testCacheRove(){
        for (int i = 0 ; i < 3 ; i++){
            cacheService.cacheMethod("a");
            System.out.println("控制器调用服务"+i);
        }
        cacheService.updateMethod("a");
        System.out.println("======================缓存失效");
        for (int i = 0;i<3;i++){
            cacheService.cacheMethod("a");
            System.out.println("控制器调用服务"+i);
        }
        return "";
    }


    @Autowired
    private CollapseService collapseService;
    @RequestMapping(value = "/collapse",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String testCollapse() throws Exception{
        Future<Person> f1 = collapseService.getSinglePerson(1);
        Future<Person> f2 = collapseService.getSinglePerson(2);
        Future<Person> f3 = collapseService.getSinglePerson(3);
        Person p1 = f1.get();
        Person p2 = f2.get();
        Person p3 = f3.get();
        System.out.println(p1.getId()+"---"+p1.getName());
        System.out.println(p2.getId()+"---"+p2.getName());
        System.out.println(p3.getId()+"---"+p3.getName());
        return "";
    }


}
