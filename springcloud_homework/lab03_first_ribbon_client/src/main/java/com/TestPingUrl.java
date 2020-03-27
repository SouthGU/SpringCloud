package com;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/26/10:51
 * @Description:
 */
public class TestPingUrl {
    public static void main(String[] args) throws  Exception {
        BaseLoadBalancer Ib = new BaseLoadBalancer();
        List<Server> servers = new ArrayList<Server>();
        servers.add(new Server("localhost",8081));
        servers.add(new Server("localhost",8888));

        Ib.addServers(servers);


        Ib.setPing(new PingUrl());
        Ib.setPingInterval(2);

        Thread.sleep(6000);
        for (Server s:Ib.getAllServers()){
            System.out.println(s.getHostPort()+" State"+s.isAlive());
        }


    }
}
