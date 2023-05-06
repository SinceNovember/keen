package com.simple.keen.message.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.keen.message.model.enums.NotificationMessageType;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 通知消息
 *
 * @author SinceNovember
 * @date 2023/4/1
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_message_notification")
public class NotificationMessage {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 通知类型
     */
    @TableField(value = "type")
    private NotificationMessageType type;

    /**
     * 创建人id
     */
    @TableField(value = "create_user_id")
    private Integer createUserId;

    /**
     * 最后一次通知时间
     */
    @TableField(value = "last_notification_time")
    private LocalDateTime lastNotificationTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

}
