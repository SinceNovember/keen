package com.simple.keen.message.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class UserNotificationMessageVO {

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
     * 创建时间
     */
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 格式化后的时间
     */
    private String formatTime;

}
