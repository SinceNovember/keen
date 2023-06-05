package com.simple.keen.attachment.model.query;

import com.simple.keen.common.base.query.PageQuery;
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
public class AttachmentFolderQuery extends PageQuery {

    /**
     * 文件夹名
     */
    private String folderName;

    /**
     * 排序号
     */
    private Integer orderNum;

    /**
     * 父目录Id
     */
    private Integer pid;
}
