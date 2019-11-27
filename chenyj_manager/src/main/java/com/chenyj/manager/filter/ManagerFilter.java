package com.chenyj.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/26 23:41
 * 陈银杰专属测试
 */
@Component
public class ManagerFilter extends ZuulFilter {

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("zuul权限控制器");
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if (request.getMethod().equals("OPTIONS")){
            return null;
        }
        String requestURL=request.getRequestURL().toString();
        if (requestURL.indexOf("/admin/login")>0){
            System.out.println("登录页面"+requestURL);
            return null;
        }
        String authHeader=request.getHeader("authorization");
        try {
            if (null!=authHeader&&authHeader.startsWith("Bearer ")){
                String token=authHeader.substring(7);
                Claims claims = jwtUtil.parseJWT(token);
                if (null!=claims){
                    if ("admin".equals(claims.get("roles"))){
                        requestContext.addZuulRequestHeader("authorization",authHeader);
                        System.out.println("token 验证通过，添加了头信息"+authHeader);
                        return null;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            //终止运行
            requestContext.setSendZuulResponse(false);
            //http状态码
            requestContext.setResponseStatusCode(500);
            requestContext.setResponseBody("请求不合法");
            requestContext.getResponse().setCharacterEncoding("UTF-8");
            requestContext.getResponse().setContentType("text/html;charset=UTF‐8");
            return null;
        }
        //终止运行
        requestContext.setSendZuulResponse(false);
        //http状态码
        requestContext.setResponseStatusCode(401);
        requestContext.setResponseBody("无权访问");
        requestContext.getResponse().setCharacterEncoding("UTF-8");
        requestContext.getResponse().setContentType("text/html;charset=UTF‐8");
        return null;
    }
}
