package com.chenyj.spit.controller;

import com.chenyj.spit.pojo.Spit;
import com.chenyj.spit.service.SpitService;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/30 0:16
 * 陈银杰专属测试
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @GetMapping()
    public Result findAll(){
        return new Result(StatusCodeEnum.SUCCESS, spitService.findAll());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable String id){
        return new Result(StatusCodeEnum.SUCCESS, spitService.findById(id));
    }

    @PostMapping()
    public Result save(@RequestBody Spit spit){
        spitService.saveSpit(spit);
        return new Result(StatusCodeEnum.SUCCESS);
    }

    @PutMapping("/{id}")
    public Result upd(@PathVariable String id,@RequestBody Spit spit){
        spitService.updSpit(spit, id);
        return new Result(StatusCodeEnum.SUCCESS);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){
        spitService.delete(id);
        return new Result(StatusCodeEnum.SUCCESS);
    }

}
