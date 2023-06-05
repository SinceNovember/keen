package com.simple.keen.attachment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.attachment.model.entity.AttachmentFolder;
import com.simple.keen.attachment.model.query.AttachmentFolderQuery;
import com.simple.keen.attachment.model.vo.AttachmentFolderVO;
import java.util.List;

public interface IAttachmentFolderService extends IService<AttachmentFolder> {


    /**
     * 分页获取文件夹
     *
     * @param folderQuery 文件夹查询
     * @return 分页系文件夹VO
     */
    PageSerializable<AttachmentFolderVO> pageAttachmentFolder(AttachmentFolderQuery folderQuery);

    /**
     * 通过id获取文件夹
     *
     * @param id id
     * @return 文件夹VO
     */
    AttachmentFolderVO getAttachmentFolderById(Integer id);

    /**
     * 添加或修改文件夹
     *
     * @param folderQuery 查询
     * @return
     */
    void addOrUpdateAttachmentFolder(AttachmentFolderQuery folderQuery);

    /**
     * 删除文件夹
     *
     * @param ids id
     */
    void deleteAttachmentFolder(List<Integer> ids);
}
