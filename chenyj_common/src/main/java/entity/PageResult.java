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
    private long tatal;
    private List<T> rows;
}
