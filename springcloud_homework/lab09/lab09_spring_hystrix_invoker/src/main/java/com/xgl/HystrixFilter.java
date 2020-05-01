package com.xgl;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;


/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/12:09
 * @Description:
 */
@WebFilter(urlPatterns = "/*",filterName = "hystrixFilter")
public class HystrixFilter implements Filter {

    public void  init(FilterConfig filterConfig) throws ServletException{

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException,ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try{
            chain.doFilter(request,response);
        }finally {
            context.shutdown();
        }
    }

    public void destory(){

    }



}
