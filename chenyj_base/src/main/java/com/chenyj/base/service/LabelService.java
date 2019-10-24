package com.chenyj.base.service;

import com.chenyj.base.pojo.Label;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/23 0:22
 * 陈银杰专属测试
 */
public interface LabelService {

    List<Label> findAll();

    Label findById(String id);

    void save(Label label);

    void update(Label label);

    void delete(String id);

    Page<Label> searchByLabel(Label label, Integer pageNumber, Integer pageSize);
}
