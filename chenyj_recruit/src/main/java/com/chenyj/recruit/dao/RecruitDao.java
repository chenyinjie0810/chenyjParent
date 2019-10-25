package com.chenyj.recruit.dao;

import com.chenyj.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.chenyj.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{

    List<Recruit> findTop5ByStateOrderByCreatetimeDesc(String state);

    Recruit getDistinctById();

}
