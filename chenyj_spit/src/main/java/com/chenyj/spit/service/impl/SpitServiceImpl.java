package com.chenyj.spit.service.impl;

import com.chenyj.spit.dao.SpitDao;
import com.chenyj.spit.pojo.Spit;
import com.chenyj.spit.service.SpitService;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/29 23:03
 * 陈银杰专属测试
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SpitServiceImpl implements SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    @Override
    public Spit findById(String id) {
        return spitDao.findById(id).get();
    }

    @Override
    public void saveSpit(Spit spit) {
        spit.set_id(idWorker.nextId()+"");
        spitDao.save(spit);
    }

    @Override
    public void updSpit(Spit spit,String id) {
        spit.set_id(id);
        spitDao.save(spit);
    }

    @Override
    public void delete(String id) {
        spitDao.deleteById(id);
    }

    @Override
    public Page<Spit> findByParentid(String parentid, int pageNumber, int pageSiz) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSiz);
        return spitDao.findByParentid(parentid, pageable);
    }

    @Override
    public Spit thumbup(String id) {
        /*Spit spit = spitDao.findById(id).get();
        spit.setThumbup(spit.getThumbup()==null? 0:spit.getThumbup()+1);
        spitDao.save(spit);*/
        Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update=new Update();
        update.inc("thumbup",1);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update,"spit");
        return null;
    }


}
