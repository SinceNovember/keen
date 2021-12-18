package com.simple.chat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.chat.model.dto.MsgHistoryDTO;
import com.simple.chat.model.dto.MsgHistoryWithNameDTO;
import com.simple.chat.model.dto.RelateMsgUserDTO;
import com.simple.chat.model.entity.MsgHistory;
import com.simple.chat.server.handler.message.Msg;
import lombok.NonNull;

import java.util.List;

public interface MsgHistoryService extends IService<MsgHistory> {

    List<MsgHistoryDTO> listMsgHistory(Integer fromId, Integer toId);

    List<RelateMsgUserDTO> listUserRelateMsgUser(Integer userId);

    List<MsgHistoryWithNameDTO> listAllUnreadMsg(Integer userId);

    int countAllUnreadMsg(Integer toId);

    int countUnreadMsg(Integer fromId, Integer toId);

    void saveMsg(Msg msg);

    void clearUnreadMsg(Integer fromId, Integer toId);

    @NonNull
    MsgHistoryDTO convertTo(@NonNull MsgHistory msgHistory) ;

    @NonNull
    List<MsgHistoryDTO> convertTo(@NonNull List<MsgHistory> msgHistories) ;
}
