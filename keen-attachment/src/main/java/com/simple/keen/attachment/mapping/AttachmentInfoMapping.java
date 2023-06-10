package com.simple.keen.attachment.mapping;

import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.dto.AttachmentInfoSummaryDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.query.AttachmentFolderAndInfoQuery;
import com.simple.keen.attachment.model.vo.AttachmentInfoSummaryVO;
import com.simple.keen.attachment.model.vo.AttachmentInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttachmentInfoMapping {

    AttachmentInfoMapping INSTANCE = Mappers.getMapper(AttachmentInfoMapping.class);

    AttachmentInfoVO toAttachmentVO(AttachmentInfoDTO attachmentDTO);

    AttachmentInfoVO toAttachmentVO(AttachmentInfo attachment);

    AttachmentInfoDTO toAttachmentInfoDTO(AttachmentInfo attachment);

    AttachmentInfo toAttachment(AttachmentInfoDTO attachmentDTO);

    @Mapping(source = "name", target = "attachmentName")
    AttachmentInfoDTO toAttachmentInfoDTO(AttachmentFolderAndInfoQuery query);

    AttachmentInfoSummaryVO toAttachmentInfoSummaryVO(AttachmentInfoSummaryDTO summaryDTO);



}
