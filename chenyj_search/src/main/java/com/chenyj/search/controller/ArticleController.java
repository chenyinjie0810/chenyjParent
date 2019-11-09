package com.chenyj.search.controller;

import com.chenyj.search.pojo.Article;
import com.chenyj.search.service.ArticleService;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/9 0:20
 * 陈银杰专属测试
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * @desc: 保存
     * @author: chenyj
     * @date: 2019/11/9
     * @param article
     * @return
     */
    @PostMapping()
    public Result save(@RequestBody Article article){
        articleService.save(article);
        return new Result(StatusCodeEnum.SUCCESS);
    }
}
