package com.xgl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/11:20
 * @Description:
 */
@Component
public class PersonService {

    @Autowired
    private RestTemplate restTemplate;

    //@HystrixCommand注解修饰方法getPerson,并且配置了回退方法
    @HystrixCommand(fallbackMethod = "getPersonFallback")
    public Person getPerson(Integer id){
        Person person = restTemplate.getForObject(
                "http://spring-hystrix-provider/person/{personId}",
                Person.class,id
        );
        return person;
    }

    /**
     * 回退方法付
     */
    public Person getPersonFallback(Integer id){
        Person p = new Person();
        p.setId(0);
        p.setName("回退");
        p.setAge(-1);
        p.setMessage("request error");
        return p;
    }

    /**
     * 测试配置
     */
    @HystrixCommand(
            fallbackMethod = "testConfigFallback",groupKey = "MyGroup",
            commandKey = "MyCommandKey",threadPoolKey = "MyCommandPool",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds"
                    ,value = "1000")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1")
            }
    )
    public String testConfig(){
        try {
            Thread.sleep(1500);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "ok";
    }

    public String testConfigFallback(){
        return "Timeout- error";
    }
    @HystrixCommand(/*ignoreExceptions = {MyException.class},*/
            fallbackMethod="testExceptionFallBack")
    public String testException() throws MyException {
        throw new MyException();
    }

    public String testExceptionFallBack(){
        return "Exception-error";
    }
    }

