package com;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/21:19
 * @Description:
 */
public class MyPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        System.out.println("这是我的Ping类："+server.getHostPort());
        return true;
    }
}
