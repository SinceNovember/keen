package com.simple.keen.attachment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.attachment.model.dto.AttachmentInfoDTO;
import com.simple.keen.attachment.model.entity.AttachmentInfo;
import com.simple.keen.attachment.model.query.AttachmentFolderAndInfoQuery;
import com.simple.keen.attachment.model.vo.AttachmentFolderAndInfoVO;
import com.simple.keen.attachment.model.vo.AttachmentInfoSummaryVO;
import com.simple.keen.attachment.model.vo.AttachmentStorageVO;
import java.util.function.Consumer;
import org.springframework.web.multipart.MultipartFile;

public interface IAttachmentInfoService extends IService<AttachmentInfo> {

    /**
     * 分页获取文件夹
     *
     * @param folderQuery 文件夹查询
     * @return 分页系文件夹VO
     */
    PageSerializable<AttachmentFolderAndInfoVO> pageAttachmentFolderAndInfo(
        AttachmentFolderAndInfoQuery folderQuery);

    /**
     * 通过id获取附件信息以及数据
     *
     * @param id 附件id
     * @return AttachmentDTO
     */
    AttachmentInfoDTO getAttachmentInfoAndStorageById(Integer id);

    /**
     * 根据附件id附件存储数据base64
     *
     * @param id 附件id
     * @return 附件数据的base64值
     */
    String getAttachmentStorageDataBase64ById(Integer id);

    /**
     * 添加或更新附件信息
     *
     * @param query 附件信息
     */
    void addOrUpdateAttachmentInfo(AttachmentFolderAndInfoQuery query);

    /**
     * 保存附件
     *
     * @param file     附件
     * @param folderId 文件夹id
     * @return
     */
    AttachmentInfo addAttachmentInfoByFile(MultipartFile file, Integer folderId,
        AttachmentStorageVO attachmentStorageVO);

    /**
     * 统计数量和计算存储大小综合
     *
     * @return AttachmentInfoSummaryVO
     */
    AttachmentInfoSummaryVO countItemAndSumStorageSize();

}
