package com.simple.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.system.model.dto.UserDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户关联用户消息列表DTO
 */
@Data
public class RelateMsgUserDTO {

    private UserDTO userDTO;

    private String lastMsg;

    private List<MsgHistoryDTO> msgList;

    private int unreadMsgCount;

    @JsonFormat(pattern="HH:MM")
    private Date lastMsgTime;

    private Boolean hidden = false;

}
