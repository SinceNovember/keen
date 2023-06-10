package com.simple.keen.attachment.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class AttachmentFolderAndInfoVO {

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
     * 附件大小
     */
    private String size;

    /**
     * 创建人昵称
     */
    private String createUserNickname;



    /**
     * 排序号
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 是否是文件夹
     */
    private boolean isFolder;

    /**
     * 可编辑
     */
    private boolean editable;

}
