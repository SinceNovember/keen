package com.simple.keen.message.model.query;

import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/18
 */
@Data
@ToString
public class ChatMessageQuery {

    private Integer fromId;

    private Integer toId;

}
