package com.xgl;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/1/9:53
 * @Description:
 */

public interface ReceiveService {
    @Input("myInput")
    SubscribableChannel myInput();
}
