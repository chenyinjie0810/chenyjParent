package com.chenyj.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/17 11:02
 * 陈银杰专属测试
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTEiLCJzdWIiOiLojYnmi5_lpb0iLCJpYXQiOjE1NzM5NzExNTgsImV4cCI6MTU3Mzk3MTIxOH0.IpU8eOGUIIFOds7sKN7nyA3z3mlQJDws_KDDmt-vbTE";
        Claims itcast = Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody();
        System.out.println(itcast.getId());
        System.out.println(itcast.getSubject());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(itcast.getExpiration()));
    }
}
