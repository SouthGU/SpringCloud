package com;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

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
        return servers.get(0);
    }

    public void setLoadBalancer(ILoadBalancer Ib){
        this.Ib = Ib;
    }
    public ILoadBalancer getLoadBalancer(){
        return this.Ib;
    }

}
