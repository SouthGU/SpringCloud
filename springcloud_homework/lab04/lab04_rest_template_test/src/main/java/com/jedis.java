package com;

import redis.clients.jedis.Jedis;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/7/21:20
 * @Description:
 */
public class jedis {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.145.137");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.set("key01","100"));
        System.out.println("String取出来的值为："+jedis.get("key01"));

        jedis.hsetnx("hash01","meishi","100");
        jedis.hsetnx("hash01","tixudao","1020");
        System.out.println("Hash取出来的值为："+jedis.hgetAll("hash01"));

        jedis.lpush("list","1","2","3");
        System.out.println("List取出来的值为："+jedis.lrange("list",0,-1));

        jedis.sadd("set","set_01","set_02","set_03");
        System.out.println("Set取出来的值为："+jedis.smembers("set"));

        jedis.zadd("sort_set",100,"one");
        jedis.zadd("sort_set",200,"two");
        System.out.println("sort_set取出来的值为："+jedis.zrange("sort_set",0,-1));
        System.out.println("sort_set取出来的值为："+jedis.keys("*"));


    }
}
