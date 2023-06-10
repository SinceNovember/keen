package com.simple.keen.attachment.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 附件信息表
 *
 * @author SinceNovember
 * @date 2023/5/10
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_attachment_info")
public class AttachmentInfo {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 附件名
     */
    @TableField(value = "attachment_name")
    private String attachmentName;

    /**
     * mine类型
     */
    @TableField(value = "mine_type")
    private String mineType;

    /**
     * 内容类型
     */
    @TableField(value = "content_type")
    private String contentType;

    /**
     * 附件来源
     */
    @TableField(value = "attachment_source")
    private String attachmentSource;

    /**
     * 附件后缀
     */
    @TableField(value = "attachment_suffix")
    private String attachmentSuffix;

    /**
     * 附件大小
     */
    @TableField(value = "attachment_size")
    private long attachmentSize;

    /**
     * 创建者id
     */
    @TableField(value = "create_user_id")
    private Integer createUserId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 所属文件夹id
     */
    @TableField(value = "folder_id")
    private Integer folderId;

}
