package com.simple.keen.attachment.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.keen.attachment.mapper.AttachmentInfoMapper;
import com.simple.keen.attachment.mapping.AttachmentInfoMapping;
import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.service.IAttachmentInfoService;
import com.simple.keen.attachment.service.IAttachmentStorageService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/5/25
 */
@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnMissingBean(AliyunOSSAttachmentServiceImpl.class)
public class AttachmentInfoServiceImpl extends
    ServiceImpl<AttachmentInfoMapper, AttachmentInfo> implements
    IAttachmentInfoService {

    private final IAttachmentStorageService attachmentStorageService;

    @Override
    public AttachmentInfoDTO getAttachmentById(Integer id) {
        AttachmentInfo attachment = getById(id);
        AttachmentInfoDTO attachmentInfoDTO = AttachmentInfoMapping.INSTANCE.toAttachmentDTO(
            attachment);
        attachmentInfoDTO.setStorageData(attachmentStorageService.getStorageDataByAttachmentId(id));
        return attachmentInfoDTO;
    }

    @Override
    public String getAttachmentStorageDataBase64ById(Integer id) {
        return attachmentStorageService.getStorageDataBase64ByAttachmentId(id);
    }

    @Override
    public AttachmentInfo saveAttachmentFile(MultipartFile file) {
        AttachmentInfo attachment = new AttachmentInfo();
        attachment.setAttachmentName(file.getOriginalFilename());
        attachment.setMineType(file.getContentType());
        attachment.setAttachmentSource(file.getOriginalFilename());
        attachment.setContentType(file.getContentType());
        attachment.setAttachmentSuffix(FileUtil.getSuffix(file.getOriginalFilename()));
        attachment.setCreateUserId(StpUtil.getLoginIdAsInt());
        attachment.setCreateTime(LocalDateTime.now());
        save(attachment);
        //保存附件数据
        attachmentStorageService.save(file, attachment.getId());
        return attachment;
    }

}
