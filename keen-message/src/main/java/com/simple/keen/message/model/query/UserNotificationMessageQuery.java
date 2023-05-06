package com.simple.keen.message.model.query;

import com.simple.keen.common.base.query.PageQuery;
import com.simple.keen.message.model.enums.NotificationMessageType;
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
public class UserNotificationMessageQuery extends PageQuery {

    private Integer id;

    private String title;

    private String content;

    private Integer userId;

    private NotificationMessageType type;

}
