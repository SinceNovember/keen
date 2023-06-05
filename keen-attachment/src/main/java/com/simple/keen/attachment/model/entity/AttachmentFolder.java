package com.simple.keen.attachment.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.keen.common.base.entity.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/6/3
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "t_attachment_folder")
public class AttachmentFolder {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文件夹名
     */
    @TableField(value = "folder_name")
    private String folderName;

    /**
     * 创建人id
     */
    @TableField(value = "create_user_id")
    private Integer createUserId;

    /**
     * 排序号
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 父目录Id
     */
    @TableField(value = "pid")
    private Integer parentId;
}
