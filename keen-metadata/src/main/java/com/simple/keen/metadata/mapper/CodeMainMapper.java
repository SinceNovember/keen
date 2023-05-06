package com.simple.keen.metadata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.common.base.OptionModel;
import com.simple.keen.metadata.model.dto.CodeMainDTO;
import com.simple.keen.metadata.model.entity.CodeMain;
import com.simple.keen.metadata.model.query.CodeMainQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CodeMainMapper extends BaseMapper<CodeMain> {

    @Select("<script>"
        + "select * from t_code_main "
        + "<where>"
        + "<if test=\"codeName != null and codeName != ''\">"
        + "and code_name like concat('%', #{codeName}, '%') "
        + "</if>"
        + "</where>"
        + "</script>")
    List<CodeMainDTO> selectCodeMainList(CodeMainQuery systemConfigQuery);

    @Select("<script>"
        + "select item_text as label, item_value as value from "
        + "(select id from t_code_main where code_name = #{codeName}) "
        + "a join t_code_item b on a.id = b.code_id "
        + "order by b.order_num desc"
        + "</script>")
    List<OptionModel> selectCodeMainAsModelListByCodeName(String codeName);

}
