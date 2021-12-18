package com.simple.chat.model.dto;

import lombok.Data;

@Data
public class MsgHistoryWithNameDTO  extends MsgHistoryDTO{

    private String nickname;
}
