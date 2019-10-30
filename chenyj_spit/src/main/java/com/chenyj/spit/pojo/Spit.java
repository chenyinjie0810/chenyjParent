package com.chenyj.spit.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/29 22:19
 * 陈银杰专属测试
 */
@Data
public class Spit implements Serializable {

    @Id
    private String _id;
    private String content;
    private Date publishtime;
    private String userid;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentid;
}
