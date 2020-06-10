//package com.xgl;
//
//import com.netflix.hystrix.HystrixCommand;
//import com.netflix.hystrix.HystrixCommandGroupKey;
//
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeoutException;
//
///**
// * @Auther: sise.xgl
// * @Date: 2020/5/31/0:21
// * @Description:
// */
//public class CommandHelloWorld extends HystrixCommand<String> {
//
//    private final String name;
//
//    public CommandHelloWorld(String name) {
//        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
//        this.name = name ;
//    }
//
//    @Override
//    protected String run() throws Exception {
//        return "hello"+ name +"! thread" +Thread.currentThread().getName();
//    }
//
//    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//        CommandHelloWorld commandHelloWorld = new CommandHelloWorld("Synchronous hystrix");
//        String s = commandHelloWorld.execute();
//        System.out.println("同步======="+s);
//
//        commandHelloWorld = new CommandHelloWorld("Asynchronous - hystrix");
//        Future<String> future = commandHelloWorld.queue();
//        s = future.get(100, TimeUnit.MILLISECONDS);
//        System.out.println("异步===="+s);
//
//        System.out.println("主函数-------"+Thread.currentThread().getName());
//    }
//}
