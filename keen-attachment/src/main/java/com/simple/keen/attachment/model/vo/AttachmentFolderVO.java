package com.simple.keen.attachment.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.keen.attachment.model.dto.AttachmentFolderDTO;
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
public class AttachmentFolderVO {

    /**
     * id
     */
    private Integer id;

    /**
     * 文件夹名
     */
    private String folderName;

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
     * 子级
     */
    private List<AttachmentFolderVO> children;
}
