package com.simple.system.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class OptionDTO {

    private String label;

    private Integer value;

    private List<OptionDTO> children;
}
