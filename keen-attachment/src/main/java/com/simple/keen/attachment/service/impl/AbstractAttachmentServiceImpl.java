package com.simple.keen.attachment.service.impl;

import cn.hutool.core.io.IoUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.enums.AttachmentUploadPlatformType;
import com.simple.keen.attachment.model.vo.AttachmentStorageVO;
import com.simple.keen.attachment.model.vo.AttachmentUploadVO;
import com.simple.keen.attachment.service.IAttachmentInfoService;
import com.simple.keen.attachment.service.IAttachmentService;
import com.simple.keen.attachment.service.IAttachmentStorageService;
import com.simple.keen.common.consts.Consts;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.common.utils.HttpContextUtils;
import com.simple.keen.common.utils.StringUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Resource
    protected IAttachmentStorageService attachmentStorageService;

    @Autowired(required = false)
    protected  OSSClient ossClient;

    @Value("${aliyun.oss.urlPrefix}")
    protected String urlPrefix;

    @Value("${aliyun.oss.bucketName}")
    protected String bucketName;

    @Value("${aliyun.oss.dirPrefix:images/}")
    protected String dirPrefix;

    /**
     * 图像类型
     */
    private static String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String uploadImage(MultipartFile file) {
        checkImgSuffix(file);
        AttachmentUploadVO attachmentUploadVO = uploadAttachment(file, null);
        return getImageUrl(file, attachmentUploadVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AttachmentUploadVO uploadAttachment(MultipartFile file, Integer folderId) {
        checkFileSize(file);
        AttachmentStorageVO attachmentStorage = addAttachmentStorage(file);
        AttachmentInfo attachmentInfo = attachmentInfoService.addAttachmentInfoByFile(file,
            folderId, attachmentStorage);
        return AttachmentUploadVO.builder()
            .id(attachmentInfo.getId())
            .url(attachmentInfo.getUploadUrl())
            .build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAttachment(List<Integer> ids) {
        List<AttachmentInfo> attachmentInfos = attachmentInfoService.listByIds(ids);
        attachmentInfos.forEach(info -> {
            if (info.getUploadPlatformType() == AttachmentUploadPlatformType.ALIYUN) {
                deleteAttachmentStorageByAliyun(info);
            } else {
                deleteAttachmentStorageByDatabase(info);
            }
        });
        attachmentInfoService.removeByIds(ids);
    }

    private void deleteAttachmentStorageByAliyun(AttachmentInfo attachmentInfo) {
        if (ossClient == null) {
            throw new KeenException(MsgConsts.ALIYUN_FILE_ERROR_MSG);
        }
        if (StringUtils.isNotBlank(attachmentInfo.getUploadUrl())) {
            ossClient.deleteObject(bucketName,
                StringUtils.subAfter(attachmentInfo.getUploadUrl(), urlPrefix, true));
        }
    }

    private void deleteAttachmentStorageByDatabase(AttachmentInfo attachmentInfo) {
        attachmentStorageService.removeById(attachmentInfo.getUploadUrl());
    }

    @Override
    public void downloadAttachment(Integer attachmentId) {
        AttachmentInfoDTO attachmentDTO = attachmentInfoService.getAttachmentInfoAndStorageById(
            attachmentId);
        HttpServletResponse response = HttpContextUtils.getHttpServletResponse();
        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Disposition",
            "attachment;filename=" + attachmentDTO.getAttachmentName());
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        if (attachmentDTO.getUploadPlatformType() == AttachmentUploadPlatformType.ALIYUN) {
            downloadByAliyun(attachmentDTO.getUploadUrl(), response);
        } else {
            downloadByDatabase(attachmentDTO.getStorageData(), response);
        }
    }

    private void downloadByAliyun(String url, HttpServletResponse response) {
        if (ossClient == null) {
            throw new KeenException(MsgConsts.ALIYUN_FILE_ERROR_MSG);
        }
        String objectName = StringUtils.subAfter(url, urlPrefix, true);
        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);
        response.setContentLength((int) ossObject.getObjectMetadata().getContentLength());

        try (BufferedInputStream inputStream = new BufferedInputStream(ossObject.getObjectContent());
            ServletOutputStream outputStream = response.getOutputStream()) {
            IoUtil.copy(inputStream, outputStream); // 将输入流的内容复制到输出流中
            response.flushBuffer();
        }  catch (IOException e) {
            throw new KeenException(MsgConsts.FILE_DOWNLOAD_ERROR_MSG);
        }
    }

    private void downloadByDatabase(byte[] storage, HttpServletResponse response) {
        response.setContentLength(storage.length);
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            outputStream.write(storage);
            response.flushBuffer();
        } catch (IOException e) {
            throw new KeenException(MsgConsts.FILE_DOWNLOAD_ERROR_MSG);
        }
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

    protected abstract String getImageUrl(MultipartFile file, AttachmentUploadVO attachmentUploadVO);

    protected abstract AttachmentStorageVO addAttachmentStorage(MultipartFile file);

}
