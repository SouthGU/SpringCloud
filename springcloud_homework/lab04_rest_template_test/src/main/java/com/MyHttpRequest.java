package com;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;

/**
 * @Auther: sise.xgl
 * @Date: 2020/4/6/22:39
 * @Description:
 */
public class MyHttpRequest implements HttpRequest {

    private HttpRequest sourceRequest;

    public MyHttpRequest(HttpRequest sourceRequest) {
        this.sourceRequest = sourceRequest;
    }

    public String getMethodValue() {
        return null;
    }

    public URI getURI() {
        try{
            String oldUri = sourceRequest.getURI().toString();
            URI newUri = new URI("http://localhost:8080/hello");
            return newUri;
        }catch (Exception e){
            e.printStackTrace();
        }
        return sourceRequest.getURI();
    }

    public HttpHeaders getHeaders() {
        return sourceRequest.getHeaders();
    }

    @Override
    public HttpMethod getMethod(){
        return sourceRequest.getMethod();
    }
}
