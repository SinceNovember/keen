package com.simple.chat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.chat.dao.MsgHistoryMapper;
import com.simple.chat.model.dto.MsgHistoryDTO;
import com.simple.chat.model.dto.MsgHistoryWithNameDTO;
import com.simple.chat.model.dto.RelateMsgUserDTO;
import com.simple.chat.model.entity.MsgHistory;
import com.simple.chat.model.enums.MsgReadType;
import com.simple.chat.model.enums.MsgType;
import com.simple.chat.server.handler.message.Msg;
import com.simple.chat.service.MsgHistoryService;
import com.simple.monitor.service.SessionService;
import com.simple.system.dao.DeptMapper;
import com.simple.system.model.dto.UserDTO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MsgHistoryServiceImpl extends ServiceImpl<MsgHistoryMapper, MsgHistory> implements MsgHistoryService{

    @Resource
    private DeptMapper deptMapper;

    @Resource
    private MsgHistoryMapper msgHistoryMapper;

    @Resource
    private SessionService sessionService;

    @Override
    public List<MsgHistoryDTO> listMsgHistory(Integer fromId, Integer toId) {
        return msgHistoryMapper.listMsgHistory(fromId, toId);
    }

    @Override
    public List<RelateMsgUserDTO> listUserRelateMsgUser(Integer userId) {
        List<RelateMsgUserDTO> relateUserList = new ArrayList<>();
        List<UserDTO> userList = msgHistoryMapper.listRelatedUserByUserId(userId);
        userList.forEach(user -> {
            user.setDeptName(deptMapper.selectById(user.getDeptId()).getDeptName());
            user.setOnline(sessionService.isOnline(user.getUserId()));
            RelateMsgUserDTO relateMsgUserDTO = new RelateMsgUserDTO();
            relateMsgUserDTO.setUserDTO(user);
            List<MsgHistoryDTO> msgList = msgHistoryMapper.listMsgHistory(userId, user.getUserId());
            relateMsgUserDTO.setMsgList(msgList);
            //设置对该用户是否有未读的消息数
            relateMsgUserDTO.setUnreadMsgCount(countUnreadMsg(user.getUserId(), userId));
            //添加时间线
            lookupMsgTimeLine(msgList);
            relateUserList.add(relateMsgUserDTO);
        });
        Comparator<RelateMsgUserDTO> comparator = Comparator.comparing(user -> user.getMsgList().get(user.getMsgList().size() - 1).getCreateTime());
        relateUserList.sort(comparator.reversed());
        return relateUserList;
    }

    @Override
    public List<MsgHistoryWithNameDTO> listAllUnreadMsg(Integer userId) {
        return msgHistoryMapper.listUnreadMsgHistory(userId);
    }

    /**
     * 获取所有未读的消息
     * @param toId
     * @return
     */
    @Override
    public int countAllUnreadMsg(Integer toId) {
        LambdaQueryWrapper<MsgHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MsgHistory::getToId, toId).eq(MsgHistory::getIsRead, MsgReadType.NOT_READ);
        return count(queryWrapper);
    }

    /**
     * 获取未读的消息
     * @param fromId
     * @param toId
     * @return
     */
    @Override
    public int countUnreadMsg(Integer fromId, Integer toId) {
        LambdaQueryWrapper<MsgHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MsgHistory::getFromId, fromId).eq(MsgHistory::getToId, toId).eq(MsgHistory::getIsRead, MsgReadType.NOT_READ);
        return count(queryWrapper);
    }

    @Override
    public void saveMsg(Msg msg) {
        MsgHistory msgHistory = new MsgHistory();
        msgHistory.setId(UUID.randomUUID().toString());
        msgHistory.setFromId(msg.getFromId());
        msgHistory.setToId(msg.getToId());
        msgHistory.setContent(msg.getContent());
        msgHistory.setType(MsgType.TEXT);
        msgHistory.setCreateTime(new Date());
        msgHistory.setIsRead(MsgReadType.NOT_READ);
        this.save(msgHistory);
    }

    /**
     * 清楚未读的消息
     * @param fromId
     * @param toId
     */
    @Override
    public void clearUnreadMsg(Integer fromId, Integer toId) {
        LambdaUpdateWrapper<MsgHistory> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(MsgHistory::getIsRead, MsgReadType.IS_READ).eq(MsgHistory::getFromId, fromId).eq(MsgHistory::getToId, toId);
        this.update(updateWrapper);
    }

    /**
     * 寻找并添加消息时间线
     * @param msgList
     */
    private void lookupMsgTimeLine(List<MsgHistoryDTO> msgList) {
        if (!CollectionUtils.isEmpty(msgList)) {
            for (int i = 0; i < msgList.size(); i++) {
                if (i == 0 || (msgList.get(i).getCreateTime().getTime() - msgList.get(i - 1).getCreateTime().getTime() > 1000 * 60 * 3)) {
                    msgList.get(i).setTimeLine(DateFormatUtils.format(msgList.get(i).getCreateTime(), DateUtils.isSameDay(new Date(), msgList.get(i).getCreateTime()) ? "HH:mm" : "MM-dd HH:mm"));
                }
            }
        }

    }

    @Override
    public MsgHistoryDTO convertTo(MsgHistory msgHistory) {
        Assert.notNull(msgHistory,"msgHistory is not null");
        return new MsgHistoryDTO().covertFrom(msgHistory);
    }

    public List<MsgHistoryDTO> convertTo(List<MsgHistory> msgHistories) {
        return msgHistories.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }


}
