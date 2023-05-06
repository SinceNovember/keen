package com.simple.keen.common.base.query;

import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * 页面查询
 * 分页查询条件
 *
 * @author SinceNovember
 * @date 2022/11/22
 */
@ToString
@Data
public class PageQuery {

    /**
     * 列表多选ID列表
     */
    private List<Integer> ids;

    /**
     * 页号
     */
    private int pageNum;

    /**
     * 页面大小
     */
    private int pageSize;

    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 排序类别。。
     */
    private String orderType;
}
