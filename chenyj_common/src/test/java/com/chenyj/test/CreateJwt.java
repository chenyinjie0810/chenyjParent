package com.chenyj.test;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/17 10:55
 * 陈银杰专属测试
 */
public class CreateJwt {

    public static void main(String[] args) {
        JwtBuilder jwtBuilder= Jwts.builder()
                .setId("111")
                .setSubject("草拟好")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "itcast")
                .setExpiration(new Date(System.currentTimeMillis()+60*1000));
        System.out.println(jwtBuilder.compact());
    }
}
