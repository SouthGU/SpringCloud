package com.xgl;


import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;



/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/23:55
 * @Description:
 */
public class FallbackTest {
    public static void main(String[] args) {

        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.circuitBreaker.forceOpen","true"
        );
        FallbakCommand command = new FallbakCommand();
        command.execute();

        /**
         * 创建第二个命令，断路器关闭
         */
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.circuitBreaker.forceOpen","false");
        FallbakCommand command2 = new FallbakCommand();
        command2.execute();
    }

    static class FallbakCommand extends HystrixCommand<String> {
        public FallbakCommand(){
            super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        }

        /**
         * 断路器被强制打开，该方法不会执行
         * @return
         * @throws Exception
         */
        @Override
        protected String run() throws Exception {
            System.out.println("命令执行");
            return "";
        }

        protected String getFallback(){
            System.out.println("执行回退方法");
            return "fallbak--> 回退方法执行了";
        }
    }
}
