package com.xgl;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/16:51
 * @Description:
 */
public class RestTemplateFilter extends ZuulFilter {

    private RestTemplate restTemplate;

    public RestTemplateFilter(RestTemplate template){
        this.restTemplate = template;
    }

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        if(uri.indexOf("rest-tpl-sale") != -1){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get("serviceId");
        String uri = (String) ctx.get("requestURI");
        String url ="http://"+serviceId+uri;
        System.out.println("执行RestTemplateFilter，调用的url："+uri);
        String result = this.restTemplate.getForObject(url,String.class);
        ctx.setResponseBody(result);
        ctx.sendZuulResponse();
        return null;
    }
}
