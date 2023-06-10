package com.simple.keen.attachment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.attachment.model.entity.AttachmentFolder;
import com.simple.keen.attachment.model.query.AttachmentFolderAndInfoQuery;
import com.simple.keen.attachment.model.vo.AttachmentFolderAndInfoVO;
import java.util.List;

public interface IAttachmentFolderService extends IService<AttachmentFolder> {


    /**
     * 添加或修改文件夹
     *
     * @param folderQuery 查询
     * @return
     */
    void addOrUpdateAttachmentFolder(AttachmentFolderAndInfoQuery folderQuery);

    /**
     * 递归删除文件夹和附件
     *
     * @param ids ids
     * @return
     */
    void recursiveDeleteFolderAndAttachment(List<Integer> ids);

    /**
     * 递归删除文件夹和附件
     *
     * @param id id
     * @return
     */
    void recursiveDeleteFolderAndAttachment(Integer id);

    /**
     * 删除文件夹
     *
     * @param id id
     */
    void deleteAttachmentFolder(Integer id);

    /**
     * 删除文件夹
     *
     * @param ids id
     */
    void deleteAttachmentFolder(List<Integer> ids);

}
