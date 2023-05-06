package com.simple.keen.system.model.dto;

import com.simple.keen.common.base.dto.BaseDTO;
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
public class DeptDTO extends BaseDTO {

    private Integer id;

    private String deptName;

    private String deptShortName;

    private Integer createUserId;

    private String description;

    private Integer parentId;

    private List<DeptDTO> children;

    private List<UserDTO> users;
}
