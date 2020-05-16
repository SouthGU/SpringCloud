package com.xgl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.stereotype.Component;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/12:15
 * @Description:
 */
@Component
public class CacheService {

    /**
     * CacheResult注解表示被修饰方法返回结果
     * 将会被缓存，需要与@HystrixCommand一起使用。
     */
    @CacheResult
    @HystrixCommand
    public Person getPerson(Integer id){
        System.out.println("执行getPerson方法");
        Person person = new Person();
        person.setId(id);
        person.setName("TOMMY");
        return person;
    }

    @CacheResult
    @HystrixCommand(commandKey = "removeKey")
    public String cacheMethod(String name){
        System.out.println("执行cacheMethod方法");
        return "hello";
    }


    /**
     * CacheRemove注解表示被修饰方法不使用缓存，缓存失效。
     * 需要与@CacheResult的缓存key关联。
     */
    @CacheRemove(commandKey = "removeKey")
    @HystrixCommand
    public String updateMethod(String name){
        return "update";
    }
}
