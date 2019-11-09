package com.chenyj.search.dao;

import com.chenyj.search.pojo.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/9 0:07
 * 陈银杰专属测试
 */
public interface ArticleDao  extends ElasticsearchRepository<Article, String> {
}