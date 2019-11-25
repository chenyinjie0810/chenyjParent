package com.chenyj.qa.client.impl;

import com.chenyj.qa.client.LabelClient;
import entity.Result;
import enums.StatusCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/11/25 22:28
 * 陈银杰专属测试
 */
@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public Result findById(String labelId) {
        return new Result(StatusCodeEnum.FAIL,"进入了熔断器");
    }
}
