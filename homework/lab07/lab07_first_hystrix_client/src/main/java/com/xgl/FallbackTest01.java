package com.xgl;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/0:27
 * @Description:
 */
public class FallbackTest01 extends HystrixCommand<String> {

    private Integer id;

    public FallbackTest01(Integer id){
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.id = id;
    }
    @Override
    protected String run() throws Exception {
        if (id%2 == 0 && id<=10){
            return "running run()"+id;
        }else {
            TimeUnit.MILLISECONDS.sleep(2000);
            return "";
        }
    }
    protected String getFallback(){
        System.out.println("running getfallback()"+id);
        return "";
    }

    public static void main(String[] args) {
        for (int i =0 ;i<30;i++){
            System.out.println(new FallbackTest01(i).execute());
        }
    }
}
