package com;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/26/10:51
 * @Description:
 */
public class MyRule implements IRule {

    ILoadBalancer Ib;
    public MyRule(){}
    public MyRule(ILoadBalancer Ib){
        this.Ib = Ib;
    }

    public Server choose(Object key){
        List<Server> servers = Ib.getAllServers();
//        return servers.get(0);
        Random random = new Random();
        final  int number = random.nextInt(10);
        if(number < 3){
            return findServer(servers,8081);
        }else {
            return findServer(servers,8085);
        }

    }

    private Server findServer(List<Server> allservers, int port) {
        for (Server server: allservers){
            if(server.getPort() == port){
                return server;
            }
        }
        System.out.println("Null port = "+ port);
        return null;
    }

    public void setLoadBalancer(ILoadBalancer Ib){
        this.Ib = Ib;
    }
    public ILoadBalancer getLoadBalancer(){
        return this.Ib;
    }

}
