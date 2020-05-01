package com.xgl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/12:34
 * @Description:
 */
@Component
public class CollapseService {

    @HystrixCollapser(batchMethod = "getPersons",collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds",value = "1000")
    })
    public Future<Person> getSinglePerson(Integer id){
        System.out.println("执行单个获取方法");
        return null;
    }

    @HystrixCommand
    public List<Person> getPersons(List<Integer> ids){
        System.out.println("收集请求，参数数量："+ids.size());
        List<Person> ps = new ArrayList<>();
        for (Integer id : ids){
            Person p = new Person();
            p.setId(id);
            p.setName("crazyit");
            ps.add(p);
        }
        return ps;
    }

}
