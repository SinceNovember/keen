package com.simple.system.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class DeptTreeDTO {

    private Integer value;

    private String label;

    /**
     * 0 代表部门， 1代表用户
     */
    private Integer nodeType;

    private List<DeptTreeDTO> children;
}
