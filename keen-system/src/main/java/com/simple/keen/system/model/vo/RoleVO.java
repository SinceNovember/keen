package com.simple.keen.system.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.keen.system.model.enums.StatusType;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Data
public class RoleVO {

    private Integer id;

    private String roleName;

    private String roleTag;

    private Integer orderNum;

    private StatusType status;

    private String description;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
