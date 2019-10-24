package com.chenyj.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/23 0:10
 * 陈银杰专属测试
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_label")
public class Label extends BasePojo{

    @Id
    private String id;

    private String labelname;

    private String state;

    private Long count;

    private Long fans;

    private String recommend;


}
