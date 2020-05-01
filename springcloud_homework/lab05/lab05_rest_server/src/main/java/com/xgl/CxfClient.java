package com.xgl;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/21/10:51
 * @Description: 客户端
 */
public class CxfClient {
    public static void main(String[] args) throws IOException {
        WebClient client = WebClient.create("http://localhost:8080/person/1");
        Response response = client.get();
        InputStream ent = (InputStream) response.getEntity();
        String content = IOUtils.readStringFromStream(ent);
        System.out.println(content);
    }
}
