package com.lab06;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/26/11:25
 * @Description:
 */
public interface RSClient {

    @GET
    @Path("/hello")
    public String sayHelloRS();
}
