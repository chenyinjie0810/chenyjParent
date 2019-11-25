package com.chenyj.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/25 23:20
 * 陈银杰专属测试
 */
@Component
public class WebFilter  extends ZuulFilter {

    /**
     * pre ：可以在请求被路由之前调用
     * route ：在路由请求时候被调post ：在route和error过滤器之后被调用
     * error ：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }


    /**
     * 通过int值来定义过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可
     * 实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("经过了zuul网关过滤器");
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
       /* String authorization =request.getHeader("Authorization");
        if (!StringUtils.isEmpty(authorization)){
            requestContext.addZuulRequestHeader("Authorization1",authorization);
        }*/
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String nextElement = headerNames.nextElement();
            String header = request.getHeader(nextElement);
            if (!StringUtils.isEmpty(header)){
                requestContext.addZuulRequestHeader(nextElement,header);
            }
        }
        return null;
    }
}
