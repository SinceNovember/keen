package com.simple.keen.monitor.mapping;

import com.simple.keen.monitor.model.dto.OperateLogDTO;
import com.simple.keen.monitor.model.entity.OperateLog;
import com.simple.keen.monitor.model.query.OperateLogQuery;
import com.simple.keen.monitor.model.vo.OperateLogVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperateLogMapping {

    OperateLogMapping INSTANCE = Mappers.getMapper(OperateLogMapping.class);

    List<OperateLogVO> toOperateLogVOList(List<OperateLogDTO> operateLogDTOS);

    OperateLogVO toOperateLogVO(OperateLogDTO operateLogDTO);

    OperateLogVO toOperateLogVO(OperateLog operateLog);

    OperateLogDTO toOperateLogDTO(OperateLogQuery operateLogQuery);

    OperateLog toOperateLog(OperateLogDTO operateLogDTO);

}
