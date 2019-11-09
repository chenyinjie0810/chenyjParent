package com.chenyj.search.service.impl;

import com.chenyj.search.dao.ArticleDao;
import com.chenyj.search.pojo.Article;
import com.chenyj.search.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/9 0:09
 * 陈银杰专属测试
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public Page<Article> findByTitleOrContentLike(String keywords, int pageNumber, int pageSize) {
        Pageable pageable=PageRequest.of(pageNumber-1, pageSize);
        return articleDao.findByTitleOrContentLike(keywords, keywords ,pageable);
    }
}
