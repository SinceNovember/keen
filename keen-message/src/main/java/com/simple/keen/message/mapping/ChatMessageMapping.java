package com.simple.keen.message.mapping;

import com.simple.keen.message.model.dto.ChatMessageDTO;
import com.simple.keen.message.model.entity.ChatMessage;
import com.simple.keen.message.model.query.ChatMessageQuery;
import com.simple.keen.message.model.vo.ChatMessagePageVO;
import com.simple.keen.message.model.vo.ChatMessageVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatMessageMapping {

    ChatMessageMapping INSTANCE = Mappers.getMapper(ChatMessageMapping.class);

    List<ChatMessageVO> toChatMessageVOList(List<ChatMessageDTO> chatMessageDTO);

    ChatMessageVO toChatMessageVO(ChatMessageDTO chatMessageDTO);

    ChatMessageVO toChatMessageVO(ChatMessage chatMessage);

    List<ChatMessagePageVO> toChatMessagePageVOList(List<ChatMessageDTO> chatMessageDTO);

    ChatMessagePageVO toChatMessagePageVO(ChatMessageDTO chatMessageDTO);

    ChatMessageDTO toChatMessageDTO(ChatMessageQuery chatMessageQuery);

    ChatMessage toChatMessage(ChatMessageDTO chatMessageDTO);

}
