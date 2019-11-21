package com.chenyj.friend.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/20 22:21
 * 陈银杰专属测试
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        //获取验证
        String authHeader=request.getHeader("Authorization");
        try {
            if (!StringUtils.isEmpty(authHeader)&&authHeader.startsWith("Bearer ")){
                String token=authHeader.substring(7);
                Claims claims = jwtUtil.parseJWT(token);
                if (claims != null) {
                    String roles= (String) claims.get("roles");
                    //如果是管理员
                    if("admin".equals(roles)){
                        request.setAttribute("admin_claims", claims);
                    }
                    //如果是用户
                    if("user".equals(roles)){
                        request.setAttribute("user_claims", claims);
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException("令牌不正确！");
        }
        return true;
    }
}
