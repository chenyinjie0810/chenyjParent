package com.chenyj.base.dao;

import com.chenyj.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/23 0:20
 * 陈银杰专属测试
 */
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
