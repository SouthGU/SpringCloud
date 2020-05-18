package com.xgl;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/17:36
 * @Description:
 */
public class ExceptionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        if (uri.indexOf("exceptionTest")!=-1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("执行ExceptionFilter，将抛出异常");
        throw  new ZuulRuntimeException(new ZuulException("exception msg",201,"my cause"));

    }
}
