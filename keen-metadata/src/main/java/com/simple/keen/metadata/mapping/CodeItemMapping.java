package com.simple.keen.metadata.mapping;

import com.simple.keen.metadata.model.dto.CodeItemDTO;
import com.simple.keen.metadata.model.entity.CodeItem;
import com.simple.keen.metadata.model.query.CodeItemQuery;
import com.simple.keen.metadata.model.vo.CodeItemVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/3
 */
@Mapper
public interface CodeItemMapping {

    CodeItemMapping INSTANCE = Mappers.getMapper(CodeItemMapping.class);

    List<CodeItemVO> toCodeItemVOList(List<CodeItemDTO> codeItemDTOS);

    CodeItemVO toCodeItemVO(CodeItemDTO codeItemDTO);

    CodeItemVO toCodeItemVO(CodeItem codeItem);

    CodeItemDTO toCodeItemDTO(CodeItemQuery codeItemQuery);

    CodeItem toCodeItem(CodeItemDTO codeItemDTO);

}
