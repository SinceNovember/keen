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
 * @date 2023/3/22
 */
@Data
@ToString
public class DeptWithUserVO {

    private Integer id;

    private String deptName;

    private String deptShortName;

    private Integer orderNum;

    private String description;

    private Integer parentId;

    private String parentName;

    private boolean show;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private List<DeptWithUserVO> children;

    private List<UserVO> users;
}
