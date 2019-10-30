package com.chenyj.spit.service.impl;

import com.chenyj.spit.dao.SpitDao;
import com.chenyj.spit.pojo.Spit;
import com.chenyj.spit.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
