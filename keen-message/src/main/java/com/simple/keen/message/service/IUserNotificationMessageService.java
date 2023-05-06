package com.simple.keen.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.message.model.entity.UserNotificationMessage;
import com.simple.keen.message.model.query.UserNotificationMessageQuery;
import com.simple.keen.message.model.vo.UserNotificationMessageVO;
import java.util.List;

public interface IUserNotificationMessageService extends IService<UserNotificationMessage> {

    /**
     * 分页获取用户消息通知
     *
     * @param userNotificationMessageQuery 用户消息通知查询
     */
    PageSerializable<UserNotificationMessageVO> pageUserNotificationMessage(
            UserNotificationMessageQuery userNotificationMessageQuery);

    /**
     * 通过id获取用户消息通知
     *
     * @param id 用户Id
     */
    UserNotificationMessageVO getUserNotificationMessageById(Integer id);

    /**
     * 添加或更新用户消息通知
     *
     * @param userNotificationMessageQuery 用户消息通知查询
     */
    void addOrUpdateUserNotificationMessage(UserNotificationMessageQuery userNotificationMessageQuery);

    /**
     * 删除用户消息通知
     *
     * @param ids id
     */
    void deleteUserNotificationMessage(List<Integer> ids);

}
