package com.simple.keen.message.model.vo;

import com.simple.keen.system.model.vo.UserVO;
import java.util.List;
import lombok.Data;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/19
 */
@Data
public class ChatMessageContactUserVO {

    private UserVO user;

    private List<ChatMessageVO> messageList;

    private long unreadMessageCount;

    private boolean hidden;

}
