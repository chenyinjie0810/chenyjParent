package com.chenyj.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.chenyj.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    @Modifying
    @Query(value = "update Article set state =1 where id = ?1")
    void updateState(String id);

    @Modifying
    @Query(value = "update Article set state =?1 where id = ?2")
    Integer updateState(String state, String id);

    @Modifying
    @Query(value = "update Article set thumbup=thumbup+1 where id = ?1")
    void addThumbup(String id);
}
