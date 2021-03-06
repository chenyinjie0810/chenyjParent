package com.chenyj.search.controller;

import com.chenyj.search.pojo.Article;
import com.chenyj.search.service.ArticleService;
import entity.PageResult;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Query;
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

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

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

    /**
     * 查询
     * @param keywords
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @GetMapping("/search/{keywords}/{pageNumber}/{pageSize}")
    public Result search(@PathVariable String keywords,
                         @PathVariable int pageNumber,
                         @PathVariable int pageSize){
        Page<Article> page=articleService.findByTitleOrContentLike(keywords, pageNumber, pageSize);
        return new Result(StatusCodeEnum.SUCCESS,new PageResult<Article>(page.getTotalPages(),page.getContent()));
    }

    @GetMapping("/search/{content}")
    public Result search(@PathVariable String content){
        return new Result(StatusCodeEnum.SUCCESS, articleService.findByContent(content));
    }

}
