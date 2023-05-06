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
public class UserNotificationMessageDTO {

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
    private Integer userId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 格式化后的时间
     */
    private String formatTime;

}
