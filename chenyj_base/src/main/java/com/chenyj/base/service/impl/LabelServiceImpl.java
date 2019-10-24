package com.chenyj.base.service.impl;

import com.chenyj.base.dao.LabelDao;
import com.chenyj.base.pojo.Label;
import com.chenyj.base.service.LabelService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/23 0:22
 * 陈银杰专属测试
 */
@Service
@Transactional
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    @Override
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    @Override
    public void save(Label label) {
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    @Override
    public void update(Label label) {
        labelDao.save(label);
    }

    @Override
    public void delete(String id) {
        labelDao.deleteById(id);
    }

    @Override
    public Page<Label> searchByLabel(Label label,Integer pageNumber, Integer pageSize) {
        Pageable pageable= PageRequest.of(pageNumber-1,pageSize);
        return labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList=new ArrayList<>();
                if (!StringUtils.isEmpty(label.getLabelname())){
                    Predicate labelNamelike = criteriaBuilder.like(root.get("labelname").as(String.class),"%"+label.getLabelname().trim()+"%");
                    predicateList.add(labelNamelike);
                }
                if (!StringUtils.isEmpty(label.getState())){
                    Predicate labelState = criteriaBuilder.equal(root.get("state").as(String.class),label.getState().trim());
                    predicateList.add(labelState);
                }
                Predicate[] predicates =new Predicate[predicateList.size()];
                predicateList.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        }, pageable);
    }


}
