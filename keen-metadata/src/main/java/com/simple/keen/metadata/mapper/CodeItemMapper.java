package com.simple.keen.metadata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.metadata.model.dto.CodeItemDTO;
import com.simple.keen.metadata.model.entity.CodeItem;
import com.simple.keen.metadata.model.query.CodeItemQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CodeItemMapper extends BaseMapper<CodeItem> {

    @Select("<script>"
        + "select * from t_code_item "
        + "<where>"
        + "<if test=\"codeId != null\">"
        + "and code_id =#{codeId} "
        + "</if>"
        + "<if test=\"itemText != null and itemText != ''\">"
        + "and item_text like concat('%', #{itemText}, '%') "
        + "</if>"
        + "</where>"
        + "</script>")
    List<CodeItemDTO> selectCodeItemList(CodeItemQuery systemConfigQuery);

}
