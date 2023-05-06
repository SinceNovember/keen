package com.simple.keen.message.model.query;

import com.simple.keen.common.base.query.PageQuery;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/31
 */
@Data
@ToString
public class ChatMessagePageQuery extends PageQuery {

    private String fromName;

    private String toName;

}
