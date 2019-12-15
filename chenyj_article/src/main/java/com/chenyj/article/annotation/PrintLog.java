package com.chenyj.article.annotation;

import java.lang.annotation.*;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/12/15 18:04
 * 陈银杰专属测试
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrintLog {
    /**
     * 日志类型：1新增，2删除，3修改，4查询
     */
    int status();

    /**
     * 模块名称
     * @return
     */
    String value() default "";
}
