package com.simple.keen.message.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/25
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_message_chat_user_hidden")
public class ChatMessageUserHidden {

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

}
