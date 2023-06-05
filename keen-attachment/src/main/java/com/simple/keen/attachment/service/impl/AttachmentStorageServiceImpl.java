package com.simple.keen.attachment.service.impl;

import cn.hutool.core.codec.Base64Encoder;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.keen.attachment.mapper.AttachmentStorageMapper;
import com.simple.keen.attachment.model.entity.AttachmentStorage;
import com.simple.keen.attachment.service.IAttachmentStorageService;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.common.exception.KeenException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
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
public class AttachmentStorageServiceImpl extends
    ServiceImpl<AttachmentStorageMapper, AttachmentStorage> implements
    IAttachmentStorageService {

    @Override
    public void save(MultipartFile file, Integer attachmentId) {
        try {
            AttachmentStorage attachmentStorage = new AttachmentStorage();
            attachmentStorage.setAttachmentId(attachmentId);
            attachmentStorage.setCreateTime(LocalDateTime.now());
            attachmentStorage.setStorageData(file.getBytes());
            attachmentStorage.setStorageSize(file.getBytes().length);
            save(attachmentStorage);
        } catch (IOException e) {
            log.error("File [{}] upload failed!", e);
            throw new KeenException(MsgConsts.FILE_UPLOAD_ERROR_MSG);
        }
    }

    @Override
    public AttachmentStorage getStorageByAttachmentId(Integer attachmentId) {
        return getOne(
            Wrappers.<AttachmentStorage>lambdaQuery()
                .eq(AttachmentStorage::getAttachmentId, attachmentId));
    }

    @Override
    public byte[] getStorageDataByAttachmentId(Integer attachmentId) {
        return Optional.ofNullable(getStorageByAttachmentId(attachmentId))
            .map(AttachmentStorage::getStorageData)
            .orElse(new byte[0]);
    }

    @Override
    public String getStorageDataBase64ById(Integer id) {
        AttachmentStorage attachmentStorage = getById(id);
        return Optional.ofNullable(attachmentStorage)
            .map(item -> item.getStorageData())
            .map(item -> Base64Encoder.encode(item))
            .orElse("");
    }

    @Override
    public String getStorageDataBase64ByAttachmentId(Integer attachmentId) {
        AttachmentStorage attachmentStorage = this.getOne(
            Wrappers.<AttachmentStorage>lambdaQuery()
                .eq(AttachmentStorage::getAttachmentId, attachmentId));
        return getStorageDataBase64ById(attachmentStorage.getId());
    }

}
