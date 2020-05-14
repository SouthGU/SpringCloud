package com.xgl;

import rx.Observable;
import rx.Observer;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;


/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/23:47
 * @Description:
 */
public class RunTest {

    public static void main(String[] args) throws Exception {
        // 使用execute方法
        RunCommand c1 = new RunCommand("使用execute方法执行命令");
        c1.execute();
        // 使用queue方法
        RunCommand c2 = new RunCommand("使用queue方法执行命令");
        c2.queue();
        // 使用 observe 方法
        RunCommand c3 = new RunCommand("使用 observe 方法执行命令");
        c3.observe();
        // 使用 toObservable 方法
        RunCommand c4 = new RunCommand("使用 toObservable 方法执行命令");
        // 调用 toObservable 方法后，命令不会马上执行
        Observable<String> ob = c4.toObservable();
        // 进行订阅，此时会执行命令
        ob.subscribe(new Observer<String>() {

            public void onCompleted() {
                System.out.println("    命令执行完成");
            }

            public void onError(Throwable e) {

            }

            public void onNext(String t) {
                System.out.println("    命令执行结果：" + t);
            }

        });
        Thread.sleep(100);
    }

    // 测试命令
    static class RunCommand extends HystrixCommand<String> {

        String msg;

        public RunCommand(String msg) {
            super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
            this.msg = msg;
        }

        protected String run() throws Exception {
            System.out.println(msg);
            return "success";
        }
    }
}