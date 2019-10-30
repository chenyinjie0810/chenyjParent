package com.chenyj.spit.dao;

import com.chenyj.spit.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/29 22:39
 * 陈银杰专属测试
 */
public interface SpitDao extends MongoRepository<Spit,String> {
}
