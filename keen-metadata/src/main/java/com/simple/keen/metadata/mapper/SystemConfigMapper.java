package com.simple.keen.metadata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.metadata.model.dto.SystemConfigDTO;
import com.simple.keen.metadata.model.entity.SystemConfig;
import com.simple.keen.metadata.model.query.SystemConfigQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SystemConfigMapper extends BaseMapper<SystemConfig> {

    @Select("<script>"
        + "select * from t_system_config "
        + "<where>"
        + "<if test=\"configName != null and configName != ''\">"
        + "and config_name like concat('%', #{configName}, '%') "
        + "</if>"
        + "<if test=\"configValue != null and configValue != ''\">"
        + "and config_value like concat('%', #{configValue}, '%') "
        + "</if>"
        + "<if test=\"description != null and description != ''\">"
        + "and description like concat('%', #{description}, '%') "
        + "</if>"
        + "</where>"
        + "</script>")
    List<SystemConfigDTO> selectSystemConfigList(SystemConfigQuery systemConfigQuery);

    @Select(" select config_value from t_system_config where config_name =#{configName}}")
    String selectConfigValueByName(@Param("configName") String configName);
}
