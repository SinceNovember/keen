package com.simple.system.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class TreeDTO {

    private Integer value;

    private String label;

    private List<TreeDTO> children;
}
