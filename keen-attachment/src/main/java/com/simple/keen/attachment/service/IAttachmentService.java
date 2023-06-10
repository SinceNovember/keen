package com.simple.keen.attachment.service;

import com.simple.keen.attachment.model.vo.AttachmentUploadVO;
import java.io.UnsupportedEncodingException;
import java.util.List;
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
     * @param file     文件
     * @param folderId 文件夹id
     * @return
     */
    AttachmentUploadVO uploadAttachment(MultipartFile file, Integer folderId);

    /**
     * 根据附件id下载附件
     *
     * @param attachmentId 附件id
     * @return
     */
    void downloadAttachment(Integer attachmentId);

    /**
     * 删除附件
     *
     * @param ids id列表
     * @return
     */
    void deleteAttachment(List<Integer> ids);

}
