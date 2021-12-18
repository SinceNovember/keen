package com.simple.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.chat.model.entity.MsgHistory;
import com.simple.chat.model.enums.MsgReadType;
import com.simple.common.model.dto.base.OutputConverter;
import lombok.Data;

import java.util.Date;

/**
 * 消息历史DTO
 */
@Data
public class MsgHistoryDTO implements OutputConverter<MsgHistoryDTO, MsgHistory> {

    private String id;

    private String content;

    private String avatar;

    private String from;

    private MsgReadType isRead;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    //要展示的时间线
    private String timeLine;

}
