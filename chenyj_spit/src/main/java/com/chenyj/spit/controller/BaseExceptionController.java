package com.chenyj.spit.controller;

import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/3 0:39
 * 陈银杰专属测试
 */
@ControllerAdvice
public class BaseExceptionController {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
       return new Result(StatusCodeEnum.FAIL, e.getMessage());
    }
}
