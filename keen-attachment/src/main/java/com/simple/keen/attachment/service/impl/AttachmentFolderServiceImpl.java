package com.simple.keen.attachment.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.keen.attachment.mapper.AttachmentFolderMapper;
import com.simple.keen.attachment.mapping.AttachmentFolderMapping;
import com.simple.keen.attachment.model.dto.AttachmentFolderAndInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentFolder;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.query.AttachmentFolderAndInfoQuery;
import com.simple.keen.attachment.service.IAttachmentFolderService;
import com.simple.keen.attachment.service.IAttachmentInfoService;
import com.simple.keen.attachment.service.IAttachmentService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/6/3
 */
@Service
@RequiredArgsConstructor
public class AttachmentFolderServiceImpl extends
    ServiceImpl<AttachmentFolderMapper, AttachmentFolder> implements IAttachmentFolderService {

    private final IAttachmentService attachmentService;

    private final IAttachmentInfoService attachmentInfoService;

    @Override
    public void addOrUpdateAttachmentFolder(AttachmentFolderAndInfoQuery folderQuery) {
        AttachmentFolderAndInfoDTO attachmentFolderDTO = AttachmentFolderMapping.INSTANCE.toAttachmentFolderDTO(
            folderQuery);
        if (attachmentFolderDTO.getId() == null) {
            attachmentFolderDTO.setCreateTime(LocalDateTime.now());
            attachmentFolderDTO.setCreateUserId(StpUtil.getLoginIdAsInt());
        }
        this.saveOrUpdate(AttachmentFolderMapping.INSTANCE.toAttachmentFolder(attachmentFolderDTO));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAttachmentFolder(Integer id) {
        removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAttachmentFolder(List<Integer> ids) {
        remove(Wrappers.<AttachmentFolder>lambdaUpdate()
            .in(AttachmentFolder::getId, ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void recursiveDeleteFolderAndAttachment(List<Integer> ids) {
        ids.forEach(this::recursiveDeleteFolderAndAttachment);
    }

    /**
     * 递归删除文件夹和附件
     *
     * @param id id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void recursiveDeleteFolderAndAttachment(Integer id) {
        //删除当前文件
        removeById(id);
        //查找并删除当前文件夹下的文件
        List<AttachmentInfo> attachmentInfos = attachmentInfoService.list(
            Wrappers.<AttachmentInfo>lambdaQuery()
                .eq(AttachmentInfo::getFolderId, id));
        if (CollectionUtil.isNotEmpty(attachmentInfos)) {
            attachmentService.deleteAttachment(
                attachmentInfos.stream()
                    .map(AttachmentInfo::getId)
                    .collect(Collectors.toList()));
        }
        //获取子文件夹
        List<AttachmentFolder> childrenFolders = list(
            Wrappers.<AttachmentFolder>lambdaQuery()
                .eq(AttachmentFolder::getParentId, id));
        childrenFolders.forEach(item -> recursiveDeleteFolderAndAttachment(item.getId()));
    }

}
