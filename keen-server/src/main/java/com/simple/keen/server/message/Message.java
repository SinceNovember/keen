package com.simple.keen.server.message;

import com.simple.keen.message.model.enums.ChatMessageContentType;
import com.simple.keen.message.model.enums.MessageType;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/15
 */
@Data
@ToString
public class Message {

    private MessageType type;

    private ChatMessageContentType contentType;

    private Integer toId;

    private Integer fromId;

    private String content;

}
