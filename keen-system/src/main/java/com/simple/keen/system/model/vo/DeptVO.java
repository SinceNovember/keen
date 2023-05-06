package com.simple.keen.system.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/10
 */
@Data
@ToString
public class DeptVO {

    private Integer id;

    private String deptName;

    private String deptShortName;

    private Integer orderNum;

    private String description;

    private Integer parentId;

    private String parentName;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private List<DeptVO> children;

    private List<DeptUserVO> users;
}
