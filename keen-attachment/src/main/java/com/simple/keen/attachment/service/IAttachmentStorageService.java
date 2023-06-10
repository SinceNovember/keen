package com.simple.keen.attachment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.keen.attachment.model.entity.AttachmentStorage;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface IAttachmentStorageService extends IService<AttachmentStorage> {

    /**
     * 保存附件文件
     *
     * @param file         文件
     * @param attachmentId 附件标识
     * @return
     */
    void addAttachmentStorage(MultipartFile file, Integer attachmentId);

    /**
     * 根据附件id获取附件存储信息
     *
     * @param attachmentId 附件id
     * @return 附件信息
     */
    AttachmentStorage getStorageByAttachmentId(Integer attachmentId);

    /**
     * 根据附件id获取存储数据
     *
     * @param attachmentId 附件标识
     * @return
     */
    byte[] getStorageDataByAttachmentId(Integer attachmentId);

    /**
     * 通过id获取base64存储数据
     *
     * @param id id
     * @return
     */
    String getStorageDataBase64ById(Integer id);

    /**
     * 通过附件id获取附件存储数据base64
     *
     * @param attachmentId 附件标识
     * @return
     */
    String getStorageDataBase64ByAttachmentId(Integer attachmentId);

    /**
     * 根据附件信息id删除附件存储信息
     *
     * @param attachmentId 附件信息id
     */
    void deleteAttachmentStorageByAttachmentId(Integer attachmentId);

    /**
     * 根据附件信息id删除附件存储信息
     *
     * @param attachmentIds 附件信息ids
     */
    void deleteAttachmentStorageByAttachmentIds(List<Integer> attachmentIds);

}
