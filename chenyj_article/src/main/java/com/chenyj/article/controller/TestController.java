package com.chenyj.article.controller;

import com.chenyj.article.thread.TestThread;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2020/5/11 11:13
 * 陈银杰
 */
@RestController
public class TestController {

    @Autowired
    private TestThread testThread;

    @GetMapping("test")
    public Result test(){
        testThread.executeAsyncTask2(1);
        return new Result(StatusCodeEnum.SUCCESS);
    }
}
