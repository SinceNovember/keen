package com.simple.keen.attachment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import org.springframework.web.multipart.MultipartFile;

public interface IAttachmentInfoService extends IService<AttachmentInfo> {

    /**
     * 通过id获取附件信息
     *
     * @param id 附件id
     * @return AttachmentDTO
     */
    AttachmentInfoDTO getAttachmentById(Integer id);



    /**
     * 根据附件id附件存储数据base64
     *
     * @param id 附件id
     * @return 附件数据的base64值
     */
    String getAttachmentStorageDataBase64ById(Integer id);

    /**
     * 保存附件
     *
     * @param file 附件
     * @return 附件信息
     */
    AttachmentInfo saveAttachmentFile(MultipartFile file);

}
