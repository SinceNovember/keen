package com.simple.keen.attachment.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.attachment.mapper.AttachmentFolderMapper;
import com.simple.keen.attachment.mapping.AttachmentFolderMapping;
import com.simple.keen.attachment.model.dto.AttachmentFolderDTO;
import com.simple.keen.attachment.model.entity.AttachmentFolder;
import com.simple.keen.attachment.model.query.AttachmentFolderQuery;
import com.simple.keen.attachment.model.vo.AttachmentFolderVO;
import com.simple.keen.attachment.service.IAttachmentFolderService;
import com.simple.keen.common.utils.PageHelperUtils;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/6/3
 */
@Service
public class AttachmentFolderServiceImpl extends
    ServiceImpl<AttachmentFolderMapper, AttachmentFolder> implements IAttachmentFolderService {

    @Override
    public PageSerializable<AttachmentFolderVO> pageAttachmentFolder(
        AttachmentFolderQuery folderQuery) {
        PageHelperUtils.startPage(folderQuery);
        List<AttachmentFolderDTO> attachmentFolderDTOS = baseMapper.selectAttachmentFolderList(
            folderQuery);

        return PageHelperUtils.convertPageDto2Vo(attachmentFolderDTOS,
            AttachmentFolderMapping.INSTANCE::toAttachmentFolderVOList);
    }

    @Override
    public AttachmentFolderVO getAttachmentFolderById(Integer id) {
        return null;
    }

    @Override
    public void addOrUpdateAttachmentFolder(AttachmentFolderQuery folderQuery) {
        AttachmentFolderDTO attachmentFolderDTO = AttachmentFolderMapping.INSTANCE.toAttachmentFolderDTO(
            folderQuery);
        attachmentFolderDTO.setCreateTime(LocalDateTime.now());
        attachmentFolderDTO.setCreateUserId(StpUtil.getLoginIdAsInt());
        this.saveOrUpdate(AttachmentFolderMapping.INSTANCE.toAttachmentFolder(attachmentFolderDTO));
    }

    @Override
    public void deleteAttachmentFolder(List<Integer> ids) {

    }
}
