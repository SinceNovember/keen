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
 * .
 *
 * @author SinceNovember
 * @date 2023/5/10
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_attachment_storage")
public class AttachmentStorage {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文件名
     */
    @TableField(value = "storage_data")
    private byte[] storageData;

    /**
     * 文件名
     */
    @TableField(value = "storage_size")
    private Integer storageSize;

    /**
     * 附件标识
     */
    @TableField(value = "attachment_id")
    private Integer attachmentId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

}
