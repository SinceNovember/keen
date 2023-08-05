package com.simple.keen.monitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.monitor.model.dto.OperateLogDTO;
import com.simple.keen.monitor.model.entity.OperateLog;
import com.simple.keen.monitor.model.query.OperateLogQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OperateLogMapper extends BaseMapper<OperateLog> {

    @Select("<script>"
        + "select * from t_operate_log "
        + "<where>"
        + "<if test=\"nickname != null and nickname != ''\">"
        + "and nickname like concat('%', #{nickname}, '%') "
        + "</if>"
        + "<if test=\"operation != null and operation != ''\">"
        + "and operation like concat('%', #{operation}, '%') "
        + "</if>"
        + "<if test=\"userId != null and userId != ''\">"
        + "and user_id = #{userId}"
        + "</if>"
        + "</where> "
        + "order by operate_time desc"
        + "</script>")
    List<OperateLogDTO> selectOperateLogList(OperateLogQuery operateLogQuery);

}
