package com.simple.keen.message.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.consts.Consts;
import com.simple.keen.common.utils.LocalDateTimeUtils;
import com.simple.keen.common.utils.PageHelperUtils;
import com.simple.keen.message.mapper.UserNotificationMessageMapper;
import com.simple.keen.message.mapping.UserNotificationMessageMapping;
import com.simple.keen.message.model.dto.UserNotificationMessageDTO;
import com.simple.keen.message.model.entity.UserNotificationMessage;
import com.simple.keen.message.model.query.UserNotificationMessageQuery;
import com.simple.keen.message.model.vo.UserNotificationMessageVO;
import com.simple.keen.message.service.IUserNotificationMessageService;
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
public class UserNotificationMessageServiceImpl extends
    ServiceImpl<UserNotificationMessageMapper, UserNotificationMessage> implements
    IUserNotificationMessageService {

    @Override
    public PageSerializable<UserNotificationMessageVO> pageUserNotificationMessage(
        UserNotificationMessageQuery notificationMessageQuery) {
        notificationMessageQuery.setUserId(StpUtil.getLoginIdAsInt());
        PageHelperUtils.startPage(notificationMessageQuery, Consts.CREATE_TIME_FIELD);

        List<UserNotificationMessageDTO> userNotificationMessageDTOS =
            baseMapper.selectUserNotificationMessageList(notificationMessageQuery);
        userNotificationMessageDTOS.forEach(
            message -> message.setFormatTime(
                LocalDateTimeUtils.formatSimpleTime(message.getCreateTime())));

        return PageHelperUtils.convertPageDto2Vo(
            userNotificationMessageDTOS,
            UserNotificationMessageMapping.INSTANCE::toUserNotificationMessageVOList);
    }

    @Override
    public void addOrUpdateUserNotificationMessage(
        UserNotificationMessageQuery notificationMessageQuery) {
        UserNotificationMessageDTO notificationMessageDTO =
            UserNotificationMessageMapping.INSTANCE.toUserNotificationMessageDTO(
                notificationMessageQuery);
        notificationMessageDTO.setUserId(StpUtil.getLoginIdAsInt());
        notificationMessageDTO.setCreateTime(LocalDateTime.now());
        this.saveOrUpdate(UserNotificationMessageMapping.INSTANCE.toUserNotificationMessage(
            notificationMessageDTO));
    }

    @Override
    public UserNotificationMessageVO getUserNotificationMessageById(Integer id) {
        return UserNotificationMessageMapping.INSTANCE.toUserNotificationMessageVO(getById(id));
    }

    @Override
    public void deleteUserNotificationMessage(List<Integer> ids) {
        this.removeByIds(ids);
    }

}
