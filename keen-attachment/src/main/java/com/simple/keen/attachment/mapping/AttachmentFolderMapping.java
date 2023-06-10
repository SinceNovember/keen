package com.simple.keen.attachment.mapping;

import com.simple.keen.attachment.model.dto.AttachmentFolderAndInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentFolder;
import com.simple.keen.attachment.model.query.AttachmentFolderAndInfoQuery;
import com.simple.keen.attachment.model.vo.AttachmentFolderAndInfoVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttachmentFolderMapping {

    AttachmentFolderMapping INSTANCE = Mappers.getMapper(AttachmentFolderMapping.class);

    List<AttachmentFolderAndInfoVO> toAttachmentFolderVOList(List<AttachmentFolderAndInfoDTO> attachmentFolderDTOS);

    AttachmentFolderAndInfoVO toAttachmentFolderVO(AttachmentFolderAndInfoDTO attachmentFolderDTO);

    AttachmentFolderAndInfoVO toAttachmentFolderVO(AttachmentFolder attachmentFolder);

    AttachmentFolderAndInfoDTO toAttachmentFolderDTO(
        AttachmentFolderAndInfoQuery attachmentFolderQuery);

    @Mapping(source = "name", target = "folderName")
    AttachmentFolder toAttachmentFolder(AttachmentFolderAndInfoDTO attachmentFolderDTO);

}
