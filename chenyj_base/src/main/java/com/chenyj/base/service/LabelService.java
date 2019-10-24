package com.chenyj.base.service;

import com.chenyj.base.pojo.Label;

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
}
