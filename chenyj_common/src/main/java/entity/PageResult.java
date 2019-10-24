package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/10/22 22:57
 * 陈银杰专属测试
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private long tatal;//总记录数
    private Integer pageNumber;//当前页
    private Integer pageSize;//每页记录数
    private List<T> rows;

    public PageResult(long tatal, List rows){
        this.tatal=tatal;
        this.rows=rows;
    }
}
