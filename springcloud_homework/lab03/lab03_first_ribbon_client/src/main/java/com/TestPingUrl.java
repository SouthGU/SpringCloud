package com;

import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.client.http.RestClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/26/10:51
 * @Description:
 */
public class TestPingUrl {
    public static void main(String[] args) throws  Exception {

//        BaseLoadBalancer Ib = new BaseLoadBalancer();
//        List<Server> servers = new ArrayList<Server>();
//        servers.add(new Server("localhost",8081));
//        servers.add(new Server("localhost",8888));
//
//        Ib.addServers(servers);
//
//
//        Ib.setPing(new PingUrl());
//        Ib.setPingInterval(2);
//
//        Thread.sleep(6000);
//        for (Server s:Ib.getAllServers()){
//            System.out.println(s.getHostPort()+" State"+s.isAlive());
//        }


        ConfigurationManager.loadPropertiesFromResources("application.yml");
        RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
        Thread.sleep(6000);
        List<Server> servers = client.getLoadBalancer().getAllServers();
        System.out.println(servers.size());
        for (Server s: servers){
            System.out.println(s.getHostPort()+"State: "+ s.isAlive());
        }

    }
}
