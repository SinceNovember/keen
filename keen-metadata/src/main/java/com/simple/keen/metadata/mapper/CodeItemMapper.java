package com.simple.keen.metadata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.keen.metadata.model.dto.CodeItemDTO;
import com.simple.keen.metadata.model.entity.CodeItem;
import com.simple.keen.metadata.model.query.CodeItemQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
        + "<if test=\"itemValue != null and itemValue != ''\">"
        + "and item_value like concat('%', #{itemValue}, '%') "
        + "</if>"
        + "<if test=\"description != null and description != ''\">"
        + "and description like concat('%', #{description}, '%') "
        + "</if>"
        + "</where>"
        + "</script>")
    List<CodeItemDTO> selectCodeItemList(CodeItemQuery systemConfigQuery);

    @Select("<script>"
        + "select a.id, item_text, item_value, a.description, a.order_num, a.create_time, code_id "
        + "from t_code_main a join t_code_item b on a.id = b.code_id "
        + "where a.code_name = #{codeName} and b.item_text= #{itemText}"
        + "</script>")
    CodeItemDTO selectCodeItemByCodeNameAndItemText(
        @Param("codeName") String codeName,
        @Param("itemText") String itemText);

}
