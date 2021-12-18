package com.simple.monitor.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.monitor.model.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLog> {

}
