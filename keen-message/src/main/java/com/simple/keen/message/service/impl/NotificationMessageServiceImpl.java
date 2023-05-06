package com.simple.keen.message.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.consts.Consts;
import com.simple.keen.common.utils.PageHelperUtils;
import com.simple.keen.message.mapper.NotificationMessageMapper;
import com.simple.keen.message.mapping.NotificationMessageMapping;
import com.simple.keen.message.model.dto.NotificationMessageDTO;
import com.simple.keen.message.model.entity.NotificationMessage;
import com.simple.keen.message.model.query.NotificationMessageQuery;
import com.simple.keen.message.model.vo.NotificationMessageVO;
import com.simple.keen.message.service.INotificationMessageService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Service
@RequiredArgsConstructor
public class NotificationMessageServiceImpl extends
    ServiceImpl<NotificationMessageMapper, NotificationMessage> implements
    INotificationMessageService {

    @Override
    public PageSerializable<NotificationMessageVO> pageNotificationMessage(
        NotificationMessageQuery notificationMessageQuery) {
        PageHelperUtils.startPage(notificationMessageQuery, Consts.CREATE_TIME_FIELD);
        return PageHelperUtils.convertPageDto2Vo(
            baseMapper.selectNotificationMessageList(notificationMessageQuery),
            NotificationMessageMapping.INSTANCE::toNotificationMessageVOList);
    }

    @Override
    public void addOrUpdateNotificationMessage(NotificationMessageQuery notificationMessageQuery) {
        NotificationMessageDTO notificationMessageDTO = NotificationMessageMapping.INSTANCE.toNotificationMessageDTO(
            notificationMessageQuery);
        notificationMessageDTO.setCreateUserId(StpUtil.getLoginIdAsInt());
        notificationMessageDTO.setUpdateTime(LocalDateTime.now());
        if (notificationMessageQuery.getId() == null) {
            notificationMessageDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(
            NotificationMessageMapping.INSTANCE.toNotificationMessage(notificationMessageDTO));
    }

    @Override
    public void updateLastNotificationTime(Integer id, LocalDateTime dateTime) {
        this.update(Wrappers.<NotificationMessage>lambdaUpdate()
            .set(NotificationMessage::getLastNotificationTime, dateTime)
            .eq(NotificationMessage::getId, id));
    }

    @Override
    public NotificationMessageVO getNotificationMessageById(Integer id) {
        return NotificationMessageMapping.INSTANCE.toNotificationMessageVO(getById(id));
    }

    @Override
    public void deleteNotificationMessage(List<Integer> ids) {
        this.removeByIds(ids);
    }

}
