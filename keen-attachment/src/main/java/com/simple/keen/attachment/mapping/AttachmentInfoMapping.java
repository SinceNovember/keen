package com.simple.keen.attachment.mapping;

import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.vo.AttachmentInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttachmentInfoMapping {

    AttachmentInfoMapping INSTANCE = Mappers.getMapper(AttachmentInfoMapping.class);

    AttachmentInfoVO toAttachmentVO(AttachmentInfoDTO attachmentDTO);

    AttachmentInfoVO toAttachmentVO(AttachmentInfo attachment);

    AttachmentInfoDTO toAttachmentDTO(AttachmentInfo attachment);

    AttachmentInfo toAttachment(AttachmentInfoDTO attachmentDTO);

}
