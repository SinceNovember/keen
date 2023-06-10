package com.simple.keen.attachment.model.query;

import com.simple.keen.common.base.query.PageQuery;
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
public class AttachmentFolderAndInfoQuery extends PageQuery {

    /**
     * id
     */
    private Integer id;

    /**
     * 文件夹名
     */
    private String name;

    /**
     * 排序号
     */
    private Integer orderNum;

    /**
     * 父目录Id
     */
    private Integer parentId;

}
