package com;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/21:21
 * @Description:
 */

@RibbonClient(name = "lab04-first-service-provider",configuration = MyConfig.class)
public class CloudProviderConfig {

}
