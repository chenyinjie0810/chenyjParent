package com.chenyj.friend.controller;

import com.chenyj.friend.service.FriendService;
import entity.Result;
import enums.StatusCodeEnum;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/20 22:22
 * 陈银杰专属测试
 */
@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FriendService friendService;

    /**
     * @desc:
     * @author: chenyj
     * @date: 2019/11/20
     * @param friendid
     * @param type
     * @return
     */
    @PutMapping(value = "/like/{friendid}/{type}")
    public Result addFriend(@PathVariable String friendid, @PathVariable String type){
        //验证是否登录，并且拿到当前登录用户ID
        Claims claims = (Claims) request.getAttribute("admin_claims");
        if (StringUtils.isEmpty(claims)){
            return new Result(StatusCodeEnum.FAIL, "权限不足");
        }
        //判断是添加好友
        if (type!=null){
            if (type.equals("1")) {
            }else if (type.equals("2")){
            }
            return new Result(StatusCodeEnum.FAIL, "参数异常");
        }else {
            return new Result(StatusCodeEnum.FAIL, "参数异常");
        }
    }
}
