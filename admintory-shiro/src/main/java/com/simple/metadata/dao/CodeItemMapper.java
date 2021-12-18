package com.simple.metadata.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.metadata.model.dto.CodeItemDTO;
import com.simple.metadata.model.entity.CodeItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CodeItemMapper extends BaseMapper<CodeItem> {

    @Select("select b.* from t_code_main a join t_code_item b on a.code_id  = b.code_id where code_name=#{codeName} order by order_num desc")
    List<CodeItemDTO> listCodeItemByCodeName(String codeName);
}
