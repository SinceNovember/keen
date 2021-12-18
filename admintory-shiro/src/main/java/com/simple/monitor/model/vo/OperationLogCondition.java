package com.simple.monitor.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OperationLogCondition {

    private String nickname;

    private String createTimeFrom;

    private String createTimeTo;

    private String operation;

}
