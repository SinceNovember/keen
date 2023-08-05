package com.simple.keen.attachment.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.common.utils.StringUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
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
@ConditionalOnBean(OSSClient.class)
public class AliyunOSSAttachmentServiceImpl extends AbstractAttachmentServiceImpl {

    private final OSSClient ossClient;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.urlPrefix}")
    private String urlPrefix;

    @Value("${aliyun.oss.dirPrefix:images/}")
    private String dirPrefix;

    /**
     * 文件上传
     *
     * @param uploadFile
     * @return
     */
    @Override
    public String uploadImage(MultipartFile uploadFile) {
        // 文件新路径
        String filePath = getFilePath(uploadFile.getOriginalFilename());
        // 上传到阿里云
        try {
            ossClient.putObject(bucketName, filePath,
                new ByteArrayInputStream(uploadFile.getBytes()));
            return urlPrefix + filePath;
        } catch (Exception e) {
            throw new KeenException(e.getMessage());
        }
    }

//    @Override
//    public AttachmentUploadVO uploadAttachment(MultipartFile file) {
//        // 文件新路径
//        String filePath = getFilePath(file.getOriginalFilename());
//        // 上传到阿里云
//        try {
//            ossClient.putObject(bucketName, filePath,
//                new ByteArrayInputStream(file.getBytes()));
//        } catch (Exception e) {
//            throw new KeenException(e.getMessage());
//        }
//        return null;
//    }

    @Override
    protected String getImageUrl(MultipartFile file) {
        return null;
    }

    @Override
    protected void addAttachmentStorage(MultipartFile file, AttachmentInfo attachmentInfo) {
    }

    @Override
    protected void deleteAttachmentStorage(List<Integer> attachmentInfoIds) {
    }

    @Override
    public void downloadAttachment(Integer attachmentId) {
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

    /**
     * 查看文件列表
     *
     * @return
     */
    public List<OSSObjectSummary> list() {
        // 设置最大个数。
        final int maxKeys = 200;
        // 列举文件。
        ObjectListing objectListing = ossClient.listObjects(
            new ListObjectsRequest(bucketName).withMaxKeys(maxKeys));
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        return sums;
    }

    /**
     * 删除文件
     *
     * @param objectName
     * @return
     */
//    public FileUploadResult delete(String objectName) {
//        // 根据BucketName,objectName删除文件
//        ossClient.deleteObject(bucketName, objectName);
//        FileUploadResult fileUploadResult = new FileUploadResult();
//        fileUploadResult.setName(objectName);
//        fileUploadResult.setStatus("removed");
//        fileUploadResult.setResponse("success");
//        return fileUploadResult;
//    }

    /**
     * 下载文件
     *
     * @param os
     * @param objectName
     * @throws IOException
     */
    public void exportOssFile(OutputStream os, String objectName) throws IOException {
        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);
        // 读取文件内容。
        BufferedInputStream in = new BufferedInputStream(ossObject.getObjectContent());
        BufferedOutputStream out = new BufferedOutputStream(os);
        byte[] buffer = new byte[1024];
        int lenght = 0;
        while ((lenght = in.read(buffer)) != -1) {
            out.write(buffer, 0, lenght);
        }
        if (out != null) {
            out.flush();
            out.close();
        }
        if (in != null) {
            in.close();
        }
    }

}
