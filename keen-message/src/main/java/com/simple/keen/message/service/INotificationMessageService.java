package com.simple.keen.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.message.model.entity.NotificationMessage;
import com.simple.keen.message.model.query.NotificationMessageQuery;
import com.simple.keen.message.model.vo.NotificationMessageVO;
import java.time.LocalDateTime;
import java.util.List;

public interface INotificationMessageService extends IService<NotificationMessage> {

    /**
     * 分页获取消息通知
     *
     * @param roleQuery 消息通知查询
     * @return 分页消息通知VO
     */
    PageSerializable<NotificationMessageVO> pageNotificationMessage(
            NotificationMessageQuery roleQuery);


    /**
     * 添加或更新消息通知
     *
     * @param roleQuery 消息通知查询
     */
    void addOrUpdateNotificationMessage(NotificationMessageQuery roleQuery);

    /**
     * 修改最后通知时间
     *
     * @param id       id
     * @param dateTime 日期时间
     */
    void updateLastNotificationTime(Integer id, LocalDateTime dateTime);

    /**
     * 通过id获取消息通知
     *
     * @param id id
     * @return 消息通知信息VO
     */
    NotificationMessageVO getNotificationMessageById(Integer id);

    /**
     * 删除消息通知
     *
     * @param ids id
     */
    void deleteNotificationMessage(List<Integer> ids);

}
