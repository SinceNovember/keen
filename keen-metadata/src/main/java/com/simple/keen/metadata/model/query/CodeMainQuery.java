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
public class CodeMainQuery extends PageQuery {

    private Integer id;

    private String codeName;

    private String description;

    private Integer orderNum;

}
