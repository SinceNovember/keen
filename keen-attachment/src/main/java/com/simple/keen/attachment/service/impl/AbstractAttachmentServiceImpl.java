package com.simple.keen.attachment.service.impl;

import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.vo.AttachmentUploadVO;
import com.simple.keen.attachment.service.IAttachmentService;
import com.simple.keen.common.consts.CodeItemConsts;
import com.simple.keen.common.consts.Consts;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.common.utils.StringUtils;
import com.simple.keen.metadata.service.ICodeItemService;
import com.simple.keen.metadata.service.ICodeMainService;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;
import javax.annotation.Resource;
import lombok.RequiredArgsConstructor;
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
    private ICodeMainService codeMainService;

    @Resource
    private ICodeItemService codeItemService;

    /**
     * 图像类型
     */
    private static String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String uploadImage(MultipartFile file) {
        checkImgSuffix(file);
        uploadAttachment(file);
        return getImageUrl(file);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AttachmentUploadVO uploadAttachment(MultipartFile file) {
        checkFileSize(file);
        AttachmentInfo attachmentInfo = saveAttachFile(file);
        String suffixImageUrl = getAttachmentImageBySuffix(
            attachmentInfo.getAttachmentSuffix());
        return AttachmentUploadVO.builder()
            .id(attachmentInfo.getId())
            .url(suffixImageUrl)
            .build();
    }

    private String getAttachmentImageBySuffix(String suffix) {
        String itemValue = codeItemService.getCodeItemValueByCodeNameAndItemText(
            CodeItemConsts.ATTACHMENT_SUFFIX_TYPE_IMAGE_RELATE, suffix);
        if (StringUtils.isNotBlank(itemValue)) {
            String imageItemValue =
                codeItemService.getCodeItemValueByCodeNameAndItemText(
                    CodeItemConsts.ATTACHMENT_TYPE_IMAGE, itemValue);

            if (StringUtils.isNotBlank(imageItemValue)) {
                return imageItemValue;
            }
        }
        //根据代码项找不到对应附件的图片 返回未知图片
        return codeItemService.getCodeItemValueByCodeNameAndItemText(
            CodeItemConsts.ATTACHMENT_TYPE_IMAGE,
            CodeItemConsts.ATTACHMENT_UNKNOWN_TYPE_IMAGE);
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

    protected abstract AttachmentInfo saveAttachFile(MultipartFile file);
}
