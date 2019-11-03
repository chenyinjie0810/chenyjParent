package com.chenyj.spit.controller;

import com.chenyj.spit.pojo.Spit;
import com.chenyj.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;

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

    @Autowired
    private RedisTemplate redisTemplate;

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


    @GetMapping("/comment/{parentid}/{pageNumber}/{pageSize}")
    public Result find(@PathVariable String parentid,@PathVariable int pageNumber,@PathVariable int pageSize){
        Page<Spit> page = spitService.findByParentid(parentid, pageNumber, pageSize);
        return new Result(StatusCodeEnum.SUCCESS,new PageResult<Spit>(page.getTotalElements(),page.getContent()));
    }

    @GetMapping(value = "/thumbup/{id}")
    public Result thumbup(@PathVariable String id){
        if (redisTemplate.opsForValue().get("spit_thumbup"+id)==null){
            spitService.thumbup(id);
            redisTemplate.opsForValue().set("spit_thumbup"+id,"1");
            return new Result(StatusCodeEnum.SUCCESS);
        }else {
            return new Result(StatusCodeEnum.FAIL,"不能重复点赞");
        }
    }


}
