package com.simple.keen.converter;

import com.simple.keen.attachment.model.enums.AttachmentUploadPlatformType;
import com.simple.keen.common.base.enums.ValueEnum;
import com.simple.keen.message.model.enums.ChatMessageContentType;
import com.simple.keen.message.model.enums.ChatMessageReadType;
import com.simple.keen.message.model.enums.MessageType;
import com.simple.keen.message.model.enums.NotificationMessageType;
import com.simple.keen.system.model.enums.MenuType;
import com.simple.keen.system.model.enums.PermissionType;
import com.simple.keen.system.model.enums.RequestMethod;
import com.simple.keen.system.model.enums.StatusType;
import com.simple.keen.system.model.enums.UserSex;
import org.apache.ibatis.type.MappedTypes;

/**
 * 枚举转换器，查询/保存到数据库时调用
 *
 * @author SinceNovember
 * @date 2022/11/20
 */
@MappedTypes({
    MenuType.class,
    RequestMethod.class,
    StatusType.class,
    UserSex.class,
    PermissionType.class,
    MessageType.class,
    ChatMessageContentType.class,
    ChatMessageReadType.class,
    NotificationMessageType.class,
    AttachmentUploadPlatformType.class})
public class EnumConverter<E extends Enum<E> & ValueEnum> extends AbstractEnumConverter<E> {

    public EnumConverter(Class<E> type) {
        super(type);
    }
}
