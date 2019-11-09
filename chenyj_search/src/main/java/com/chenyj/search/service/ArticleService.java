package com.chenyj.search.service;

import com.chenyj.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/9 0:08
 * 陈银杰专属测试
 */
public interface ArticleService {

    void save(Article article);

    Page<Article> findByTitleOrContentLike(String keywords, int pageNumber, int pageSize);
}
