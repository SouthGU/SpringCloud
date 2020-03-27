package com;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/26/10:50
 * @Description:
 */
public class ChoseServerTest {


    public static void main(String[] args) {

        //1.创建负载均衡器
        //ILoadBalancer Ib = new BaseLoadBalancer();


        //2.设置自定义负载均衡规则
        BaseLoadBalancer Ib = new BaseLoadBalancer();
        Ib.setRule(new MyRule(Ib));

        //添加服务器
        List<Server> servers = new ArrayList<Server>();
        servers.add(new Server("localhost",8081));
        servers.add(new Server("localhost",8085));
        Ib.addServers(servers);

        //服务器选择
        for (int i = 0 ; i < 6 ; i++ ){
            Server server = Ib.chooseServer(null);
            System.out.println(server);
        }
    }

}
