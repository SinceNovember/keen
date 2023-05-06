package com.simple.keen.metadata.model.query;

import com.simple.keen.common.base.query.PageQuery;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/4
 */
@Data
@ToString
public class CodeItemQuery extends PageQuery {

    private Integer id;

    private String itemText;

    private String itemValue;

    private String description;

    private Integer orderNum;

    private Integer codeId;

}
