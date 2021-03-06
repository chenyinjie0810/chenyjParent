package com.chenyj.spit.service;

import com.chenyj.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/29 23:03
 * 陈银杰专属测试
 */
public interface SpitService {

    List<Spit> findAll();

    Spit findById(String id);

    void saveSpit(Spit spit);

    void updSpit(Spit spit,String id);

    void delete(String id);

    Page<Spit> findByParentid(String parentid, int pageNumber, int pageSize);

    Spit thumbup(String id);
}
