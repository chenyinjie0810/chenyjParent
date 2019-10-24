package entity;

import enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/22 22:51
 * 陈银杰专属测试
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private boolean flag;

    private Integer code;

    private String message;

    private Object data;

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(StatusCodeEnum statusCodeEnum,Object data){
        this.flag=statusCodeEnum.getFlag();
        this.message=statusCodeEnum.getMessage();
        if (null!= data) {
            this.data=data;
        }
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
