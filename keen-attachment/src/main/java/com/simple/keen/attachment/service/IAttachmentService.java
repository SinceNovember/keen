package com.simple.keen.attachment.service;

import com.simple.keen.attachment.model.vo.AttachmentUploadVO;
import org.springframework.web.multipart.MultipartFile;

public interface IAttachmentService {

    /**
     * 上传图片并返回上传后的图片地址
     *
     * @param file 文件
     * @return
     */
    String uploadImage(MultipartFile file);

    /**
     * 上传附件
     *
     * @param file 文件
     * @return
     */
    AttachmentUploadVO uploadAttachment(MultipartFile file);

    /**
     * 根据附件id下载附件
     *
     * @param attachmentId 附件id
     * @return
     */
    void downloadAttachment(Integer attachmentId);



}
