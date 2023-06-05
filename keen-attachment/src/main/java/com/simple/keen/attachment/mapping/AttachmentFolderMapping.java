package com.simple.keen.attachment.mapping;

import com.simple.keen.attachment.model.dto.AttachmentFolderDTO;
import com.simple.keen.attachment.model.entity.AttachmentFolder;
import com.simple.keen.attachment.model.query.AttachmentFolderQuery;
import com.simple.keen.attachment.model.vo.AttachmentFolderVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttachmentFolderMapping {

    AttachmentFolderMapping INSTANCE = Mappers.getMapper(AttachmentFolderMapping.class);

    List<AttachmentFolderVO> toAttachmentFolderVOList(List<AttachmentFolderDTO> attachmentFolderDTOS);

    AttachmentFolderVO toAttachmentFolderVO(AttachmentFolderDTO attachmentFolderDTO);

    AttachmentFolderVO toAttachmentFolderVO(AttachmentFolder attachmentFolder);

    AttachmentFolderDTO toAttachmentFolderDTO(AttachmentFolderQuery attachmentFolderQuery);

    AttachmentFolder toAttachmentFolder(AttachmentFolderDTO attachmentFolderDTO);

}
