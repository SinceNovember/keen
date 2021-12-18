package com.simple.common.model.enums.converter;

import com.simple.chat.model.enums.MsgReadType;
import com.simple.chat.model.enums.MsgType;
import com.simple.system.model.enums.*;
import org.apache.ibatis.type.MappedTypes;

/**
 * 枚举转换器，查询/保存到数据库时调用
 * @param <E>
 */
//@MappedTypes({LogType.class,ArticleType.class,})
@MappedTypes({UserStatus.class, RoleStatus.class, PermissionType.class, MenuType.class, SexType.class, RequestMethod.class, MsgType.class, MsgReadType.class})
public class EnumConverter<E extends Enum<E> & ValueEnum> extends AbstractEnumConverter<E> {
    public EnumConverter(Class<E> type) {
        super(type);
    }
}
