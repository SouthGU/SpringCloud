package com.xgl;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.Iterator;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/0:37
 * @Description:
 */
public class CommandHelloWorld01 extends HystrixObservableCommand<String> {
    private final String name;
    protected CommandHelloWorld01(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name ;
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> observer) {
                try {
                    if (!observer.isUnsubscribed()){
                        observer.onNext("Hello");
                        observer.onNext(name+"! thread");
                        observer.onNext(Thread.currentThread().getName());
                        observer.onCompleted();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.io());

    }

    public static void main(String[] args) {
        Observable<String> ho = new CommandHelloWorld01("Asynchronous-hystrix").observe();
        Iterator<String> iterator = ho.toBlocking().getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
