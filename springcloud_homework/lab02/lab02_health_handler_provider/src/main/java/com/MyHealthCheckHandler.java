package com;

import com.netflix.appinfo.HealthCheckHandler;

import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/19/19:47
 * @Description:
 */
@Component
public class MyHealthCheckHandler implements HealthCheckHandler {

    @Autowired
    private MyHealthIndicator indicator;

    public InstanceStatus getStatus(InstanceStatus currentStatus){
        Status status = indicator.health().getStatus();
        if(status.equals(Status.UP)){
            System.out.println("数据库正常连接");
            return InstanceStatus.UP;
        }else{
            System.out.println("数据库无法正常连接");
            return InstanceStatus.DOWN;
        }

    }



}
