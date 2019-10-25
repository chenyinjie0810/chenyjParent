package com.chenyj.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.chenyj.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    @Query(value = "SELECT * FROM tb_problem tp INNER JOIN tb_pl tl ON tp.id=tl.problemid WHERE tl.labelid= ? ORDER BY tp.replytime DESC",nativeQuery = true)
    Page<Problem> newList(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem tp INNER JOIN tb_pl tl ON tp.id=tl.problemid WHERE tl.labelid= ? ORDER BY tp.reply DESC",nativeQuery = true)
    Page<Problem> hotList(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem tp INNER JOIN tb_pl tl ON tp.id=tl.problemid WHERE tl.labelid= ? and tp.reply =0 ORDER BY tp.createtime DESC",nativeQuery = true)
    Page<Problem> waitList(String labelid, Pageable pageable);
}
