package com.simple.chat.server.handler.message;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Msg {

    /**
     * 消息类别
     */
    private MsgCode type;

    private String toId;

    private String fromId;

    private String content;

}
