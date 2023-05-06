package com.simple.keen.message.model.dto;

import com.simple.keen.message.model.enums.ChatMessageContentType;
import com.simple.keen.message.model.enums.ChatMessageReadType;
import com.simple.keen.message.model.enums.MessageType;
import java.time.LocalDateTime;
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
public class ChatMessageDTO {

    /**
     * ID
     */
    private Integer id;

    /**
     * 发送人id
     */
    private Integer fromId;

    /**
     * 发送人名称
     */
    private String fromName;

    /**
     * 接收人id
     */
    private Integer toId;

    /**
     * 接收人名称
     */
    private String toName;


    /**
     * 发送端
     */

    private String from;

    /**
     * 内容
     */
    private String content;

    /**
     * 类型
     */
    private MessageType type;

    /**
     * 消息内容类型
     */
    private ChatMessageContentType contentType;

    /**
     * 是否已读
     */
    private ChatMessageReadType isRead;

    /**
     * 未读消息数
     */
    private long unreadMessageCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
