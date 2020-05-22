package com.xgl;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/1/9:53
 * @Description:
 */

public interface ReceiveService {
    @Input("myInput")
    SubscribableChannel myInput();


    /**
     * 消息生产者的配置
     */
    String MYOUTPUT = "myoutput";

    @Output("myoutput")
    MessageChannel myoutput();

    /**
     * 消息消费者的配置
     */
    String MYINPUT = "myinput2";

    @Input("myinput2")
    SubscribableChannel myinput2();
}
