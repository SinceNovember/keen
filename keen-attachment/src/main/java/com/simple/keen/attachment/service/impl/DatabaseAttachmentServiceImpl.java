package com.simple.keen.attachment.service.impl;

import cn.hutool.core.codec.Base64Encoder;
import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.service.IAttachmentStorageService;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.common.utils.HttpContextUtils;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/6/1
 */
@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnMissingBean(AliyunOSSAttachmentServiceImpl.class)
public class DatabaseAttachmentServiceImpl extends AbstractAttachmentServiceImpl {

    private final IAttachmentStorageService attachmentStorageService;

    private static final String BASE64_IMAGE_PREFIX = "data:image/png;base64,";

    @Override
    public void addAttachmentStorage(MultipartFile file, AttachmentInfo attachmentInfo) {
        attachmentStorageService.addAttachmentStorage(file, attachmentInfo.getId());
    }

    @Override
    protected void deleteAttachmentStorage(List<Integer> attachmentInfoIds) {
        attachmentStorageService.deleteAttachmentStorageByAttachmentIds(attachmentInfoIds);
    }

    @Override
    public String getImageUrl(MultipartFile file) {
        try {
            return BASE64_IMAGE_PREFIX + Base64Encoder.encode(file.getBytes());
        } catch (IOException e) {
            throw new KeenException(MsgConsts.IMAGE_UPLOAD_ERROR_MSG);
        }
    }

    @Override
    public void downloadAttachment(Integer attachmentId) {
        AttachmentInfoDTO attachmentDTO = attachmentInfoService.getAttachmentInfoAndStorageById(attachmentId);
        HttpServletResponse response = HttpContextUtils.getHttpServletResponse();
        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Disposition",
            "attachment;filename=" + attachmentDTO.getAttachmentName());
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setContentLength(attachmentDTO.getStorageData().length);
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            outputStream.write(attachmentDTO.getStorageData());
            response.flushBuffer();
        } catch (IOException e) {
            throw new KeenException(MsgConsts.FILE_DOWNLOAD_ERROR_MSG);
        }
    }

}
