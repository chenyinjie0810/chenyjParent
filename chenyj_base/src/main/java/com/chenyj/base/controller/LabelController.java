package com.chenyj.base.controller;

import com.chenyj.base.pojo.Label;
import com.chenyj.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/22 23:56
 * 陈银杰专属测试
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * @desc: 查询所有
     * @author: chenyj
     * @date: 2019/10/24
     * @return
     */
    @GetMapping
    public Result findAll() {
        List<Label> labelList = labelService.findAll();
        return new Result(StatusCodeEnum.SUCCESS,labelList);
    }

    /**
     * @desc: 根据oid查询
     * @author: chenyj
     * @date: 2019/10/24
     * @param labelId
     * @return
     */
    @GetMapping(value = "/{labelId}")
    public Result findById(@PathVariable("labelId")String labelId){
        System.out.println("NO.2");
        Label label=labelService.findById(labelId);
        return new Result(StatusCodeEnum.SUCCESS,label);
    }

    /**
     * @desc: 保存信息
     * @author: chenyj
     * @date: 2019/10/24
     * @param label
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(StatusCodeEnum.SUCCESS,"添加成功");
    }

    /**
     * 更新信息
     * @param labelId
     * @param label
     * @return
     */
    @PutMapping(value = "/{labelId}")
    public Result update(@PathVariable("labelId")String labelId,@RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(StatusCodeEnum.SUCCESS,"更新成功");
    }

    /**
     * @desc:删除信息
     * @author: chenyj
     * @date: 2019/10/24
     * @param labelId
     * @return
     */
    @DeleteMapping(value = "/{labelId}")
    public Result delete(@PathVariable("labelId")String labelId) {
        labelService.delete(labelId);
        return new Result(StatusCodeEnum.SUCCESS,"删除成功");
    }

    /**
     * @desc: 根据条件查询分页
     * @author: chenyj
     * @date: 2019/10/24
     * @param label
     * @return
     */
    @PostMapping("/search/{pageNumber}/{pageSize}")
    public Result find(@RequestBody Label label,@PathVariable("pageNumber") Integer pageNumber,@PathVariable("pageSize") Integer pageSize){
        Page<Label> page=labelService.searchByLabel(label,pageNumber,pageSize);
        return new Result(StatusCodeEnum.SUCCESS,
                new PageResult<Label>(page.getTotalElements(),page.getNumber(),page.getSize(),page.getContent()));
    }
}
