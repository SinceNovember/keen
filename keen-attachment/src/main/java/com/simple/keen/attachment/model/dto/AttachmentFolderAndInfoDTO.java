package com.simple.keen.attachment.model.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/6/3
 */
@Data
@ToString
public class AttachmentFolderAndInfoDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 文件/文件夹名
     */
    private String name;

    /**
     * 文件后缀
     */
    private String suffix;

    /**
     * 创建人id
     */
    private Integer createUserId;

    /**
     * 创建人昵称
     */
    private String createUserNickname;

    /**
     * 附件大小
     */
    private long attachmentSize;

    /**
     * 格式化之后的大小
     */
    private String size;

    /**
     * 排序号
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 父目录Id
     */
    private Integer parentId;


    /**
     * 是否是文件夹
     */
    private boolean isFolder;

}
