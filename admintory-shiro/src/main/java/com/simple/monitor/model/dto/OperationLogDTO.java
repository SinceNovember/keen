package com.simple.monitor.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.common.model.dto.base.OutputConverter;
import com.simple.monitor.model.entity.OperationLog;
import lombok.Data;

import java.util.Date;

@Data
public class OperationLogDTO implements OutputConverter<OperationLogDTO, OperationLog> {

    private Long id;

    private String nickname;

    private String operation;

    private Long time;

    private String method;

    private String params;

    private String ip;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String location;
}
