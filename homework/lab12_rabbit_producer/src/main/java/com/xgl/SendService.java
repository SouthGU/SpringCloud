package com.xgl;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/1/9:41
 * @Description:
 */
public interface SendService {

    @Output("myInput")
    SubscribableChannel sendOrder();
}
