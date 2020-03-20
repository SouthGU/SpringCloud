package com;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient.EurekaServiceInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/19/20:21
 * @Description:
 */
@RestController
@Configuration
public class InvokerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/router",method = RequestMethod.GET)
    public String router(){
        List<ServiceInstance> instances = getServiceInstances();
        for (ServiceInstance service : instances){
            EurekaServiceInstance esi = (EurekaServiceInstance)service;
            InstanceInfo info = esi.getInstanceInfo();
            System.out.println(info.getAppName()+"==="+info.getInstanceId()+"==="+info.getStatus());
        }
        return "";
    }


    private List<ServiceInstance> getServiceInstances(){
        List<String> ids = discoveryClient.getServices();
        List<ServiceInstance> result = new ArrayList<ServiceInstance>();
        for (String id:
             ids) {
            List<ServiceInstance> ins = discoveryClient.getInstances(id);
            result.addAll(ins);
        }
        return result;
    }

}
