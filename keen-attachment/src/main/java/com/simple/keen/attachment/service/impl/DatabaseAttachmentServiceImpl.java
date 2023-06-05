package com.simple.keen.attachment.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.io.FileUtil;
import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.vo.AttachmentUploadVO;
import com.simple.keen.attachment.service.IAttachmentInfoService;
import com.simple.keen.attachment.service.IAttachmentService;
import com.simple.keen.attachment.service.IAttachmentStorageService;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.common.utils.HttpContextUtils;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    private final IAttachmentInfoService attachmentInfoService;

    private static final String BASE64_IMAGE_PREFIX = "data:image/png;base64,";

    @Override
    public AttachmentInfo saveAttachFile(MultipartFile file) {
        return attachmentInfoService.saveAttachmentFile(file);
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
        AttachmentInfoDTO attachmentDTO = attachmentInfoService.getAttachmentById(attachmentId);
        HttpServletResponse response = HttpContextUtils.getHttpServletResponse();
        response.setContentType(attachmentDTO.getContentType());
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

//        ByteArrayResource resource = new ByteArrayResource(attachmentDTO.getStorageData());
//        return ResponseEntity.ok()
//            .contentLength(attachmentDTO.getStorageData().length)
//            .contentType(MediaType.APPLICATION_OCTET_STREAM)
//            .headers(headers)
//            .body(resource);
//        System.out.println(header);
//        try {
//            ServletOutputStream outputStream = res.getOutputStream();
//            outputStream.write(attachmentDTO.getStorageData());
//            IoUtil.close(outputStream);
//        } catch (IOException e) {
//            throw new KeenException(MsgConsts.FILE_DOWNLOAD_ERROR_MSG);
//        }
    }

}
