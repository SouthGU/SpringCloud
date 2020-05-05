package com;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/26/10:50
 * @Description:
 */
public class MyPing implements IPing {

    @Override
    public boolean isAlive(Server server) {
        System.out.println("This is my Ping class: " + server.getHostPort());
        return true;
    }
}
