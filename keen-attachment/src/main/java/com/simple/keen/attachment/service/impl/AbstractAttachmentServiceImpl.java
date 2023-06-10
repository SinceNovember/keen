package com.simple.keen.attachment.service.impl;

import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.vo.AttachmentUploadVO;
import com.simple.keen.attachment.service.IAttachmentInfoService;
import com.simple.keen.attachment.service.IAttachmentService;
import com.simple.keen.common.consts.Consts;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.common.utils.StringUtils;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/6/1
 */

public abstract class AbstractAttachmentServiceImpl implements IAttachmentService {

    @Resource
    protected IAttachmentInfoService attachmentInfoService;

    /**
     * 图像类型
     */
    private static String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String uploadImage(MultipartFile file) {
        checkImgSuffix(file);
        uploadAttachment(file, null);
        return getImageUrl(file);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AttachmentUploadVO uploadAttachment(MultipartFile file, Integer folderId) {
        checkFileSize(file);
        AttachmentInfo attachmentInfo = attachmentInfoService.addAttachmentInfoByFile(file,
            folderId);
        addAttachmentStorage(file, attachmentInfo);
        return AttachmentUploadVO.builder()
            .id(attachmentInfo.getId())
            .build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAttachment(List<Integer> ids) {
        //先删除附件信息库数据
        attachmentInfoService.removeByIds(ids);
        deleteAttachmentStorage(ids);

    }

    protected void checkImgSuffix(MultipartFile file) {
        if (Stream.of(IMAGE_TYPE)
            .noneMatch(
                type -> StringUtils.endWithIgnoreCase(file.getOriginalFilename(), type))) {
            throw new KeenException(MsgConsts.UPLOAD_TYPE_ERROR_MSG);
        }
    }

    protected void checkFileSize(MultipartFile file) {
        try {
            if (file.getBytes().length > Consts.FILE_UPLOAD_MAX_SIZE) {
                throw new KeenException(MsgConsts.FILE_SIZE_EXCEEDS_THE_MAXIMUM_LIMIT_MSG);
            }
        } catch (IOException e) {
            throw new KeenException(MsgConsts.FILE_UPLOAD_ERROR_MSG);
        }
    }

    protected abstract String getImageUrl(MultipartFile file);

    protected abstract void addAttachmentStorage(MultipartFile file, AttachmentInfo attachmentInfo);

    protected abstract void deleteAttachmentStorage(List<Integer> attachmentInfoIds);
}
