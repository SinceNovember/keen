package com.simple.keen.attachment.service.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.RandomUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.enums.AttachmentUploadPlatformType;
import com.simple.keen.attachment.model.vo.AttachmentStorageVO;
import com.simple.keen.attachment.model.vo.AttachmentUploadVO;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.common.utils.HttpContextUtils;
import com.simple.keen.common.utils.StringUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/5/26
 */
@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = "aliyun.oss.enable", havingValue = "true")
public class AliyunOSSAttachmentServiceImpl extends AbstractAttachmentServiceImpl {

    @Override
    protected String getImageUrl(MultipartFile file, AttachmentUploadVO attachmentUploadVO) {
        return attachmentUploadVO.getUrl();
    }

    @Override
    protected AttachmentStorageVO addAttachmentStorage(MultipartFile file) {
        String filePath = getFilePath(file.getOriginalFilename());
        // 上传到阿里云
        try {
            ossClient.putObject(bucketName, filePath,
                new ByteArrayInputStream(file.getBytes()));
            return AttachmentStorageVO.builder()
                .uploadUrl(urlPrefix + filePath)
                .uploadPlatformType(AttachmentUploadPlatformType.ALIYUN)
                .build();
        } catch (Exception e) {
            throw new KeenException(e.getMessage());
        }
    }

    /**
     * 生成路径以及文件名
     *
     * @param sourceFileName
     * @return
     */
    private String getFilePath(String sourceFileName) {
        LocalDate now = LocalDate.now();
        return dirPrefix + now.getYear() + "-" + now.getMonthValue() + "-"
            + now.getDayOfMonth() + "/" + System.currentTimeMillis()
            + RandomUtil.randomNumbers(3) + "."
            + StringUtils.subAfter(sourceFileName, ".", true);
    }

}
