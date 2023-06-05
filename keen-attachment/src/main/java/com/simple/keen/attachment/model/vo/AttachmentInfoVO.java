package com.simple.keen.attachment.model.vo;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * 附件信息表
 *
 * @author SinceNovember
 * @date 2023/5/10
 */
@Data
@ToString
public class AttachmentInfoVO {

    /**
     * id
     */
    private Integer id;

    /**
     * 附件名
     */
    private String attachmentName;

    /**
     * mine类型
     */
    private String mineType;

    /**
     * 内容类型
     */
    private String contentType;

    /**
     * 附件来源
     */
    private String attachmentSource;

    /**
     * 附件后缀
     */
    private String attachmentSuffix;
    /**
     * 创建者id
     */
    private Integer createUserId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 所属文件夹id
     */
    private Integer folderId;

}
