package com.chenyj.base.controller;

import com.chenyj.base.pojo.Label;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Result findAll(){
        return new Result(StatusCodeEnum.SUCCESS,"查询成功");
    }

    @GetMapping(value = "/{labelId}")
    public Result findById(@PathVariable("labelId")String labelId){
        return new Result(StatusCodeEnum.SUCCESS,"查询成功");
    }

    @PostMapping
    public Result save(@RequestBody Label label){
        return new Result(StatusCodeEnum.SUCCESS,"添加成功");
    }

    @PutMapping(value = "/{labelId}")
    public Result update(@PathVariable("labelId")String labelId,@RequestBody Label label){
        return new Result(StatusCodeEnum.SUCCESS,"更新成功");
    }

    @DeleteMapping(value = "/{labelId}")
    public Result delete(@PathVariable("labelId")String labelId){
        return new Result(StatusCodeEnum.SUCCESS,"删除成功");
    }
}
