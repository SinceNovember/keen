package com.simple.keen.attachment.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;
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
public class AttachmentFolderDTO  {

    /**
     * id
     */
    private Integer id;

    /**
     * 文件夹名
     */
    private String folderName;

    /**
     * 创建人id
     */
    private Integer createUserId;

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
    private LocalDateTime createTime;

    /**
     * 父目录Id
     */
    private Integer parentId;

    /**
     * 子级
     */
    private List<AttachmentFolderDTO> children;
}
