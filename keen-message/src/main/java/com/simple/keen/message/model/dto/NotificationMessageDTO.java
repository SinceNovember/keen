package com.simple.keen.message.model.dto;

import com.simple.keen.message.model.enums.NotificationMessageType;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * 通知消息
 *
 * @author SinceNovember
 * @date 2023/4/1
 */
@Data
@ToString
public class NotificationMessageDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 通知类型
     */
    private NotificationMessageType type;

    /**
     * 创建人id
     */
    private Integer createUserId;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 最后一次通知时间
     */
    private LocalDateTime lastNotificationTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}
