package com.chenyj.article.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/12/15 18:09
 * 陈银杰专属测试
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {
    /**
     * 日志类型：1新增，2删除，3修改，查询
     */
    private int status;
    /**
     * 路径
     */
    private String path;
    /**
     * 方法名
     */
    private String name;
    /**
     * 方法修饰词
     */
    private String title;
    /**
     * 时间
     */
    private String date;
    /**
     * 参数
     */
    private Object params;
    /**
     * 错误信息
     */
    private String error;
}
