package com;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/21:15
 * @Description:
 */
public class MyRule implements IRule {

    ILoadBalancer Ib;

    public MyRule() {
    }

    public MyRule(ILoadBalancer ib) {
        this.Ib = ib;
    }

    @Override
    public Server choose(Object key) {
        List<Server> servers = Ib.getAllServers();
        System.out.println("这是自定义服务器规则类，输出服务器信息：");
        for (Server server: servers){
            System.out.println("             "+server.getHostPort());
        }
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
            this.Ib = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.Ib;
    }
}
