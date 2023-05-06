package com.simple.keen.message.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.keen.message.model.enums.ChatMessageReadType;
import com.simple.keen.message.model.enums.ChatMessageContentType;
import com.simple.keen.message.model.enums.MessageType;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/18
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_message_chat")
public class ChatMessage {

    /**
     * 消息id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发送人id
     */
    @TableField(value = "from_id")
    private Integer fromId;

    /**
     * 接收人id
     */
    @TableField(value = "to_Id")
    private Integer toId;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 类型
     */
    @TableField(value = "type")
    private MessageType type;

    /**
     * 消息内容类型
     */
    @TableField(value = "content_type")
    private ChatMessageContentType contentType;
    /**
     * 是否已读
     */
    @TableField(value = "is_read")
    private ChatMessageReadType isRead;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

}
