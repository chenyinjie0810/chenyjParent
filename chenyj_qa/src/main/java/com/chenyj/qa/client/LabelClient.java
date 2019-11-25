package com.chenyj.qa.client;

import com.chenyj.qa.client.impl.LabelClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/19 23:11
 * 陈银杰专属测试
 */
@FeignClient(value = "chenyj-base",fallback = LabelClientImpl.class)
public interface LabelClient {

    @GetMapping(value = "/label/{labelId}")
    Result findById(@PathVariable("labelId")String labelId);
}
