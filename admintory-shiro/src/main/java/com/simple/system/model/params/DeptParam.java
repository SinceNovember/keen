package com.simple.system.model.params;

import com.simple.common.model.dto.base.InputConverter;
import com.simple.system.model.entity.Dept;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DeptParam implements InputConverter<Dept> {

    private Integer deptId;

    private String deptName;

    private String deptShortName;

    private Integer parentId;

    private Integer orderNum;

    private Integer createUserId;

    private String description;

}
