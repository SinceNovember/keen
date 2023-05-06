package com.simple.keen.system.mapping;

import com.simple.keen.system.model.dto.MenuDTO;
import com.simple.keen.system.model.entity.Menu;
import com.simple.keen.system.model.query.MenuQuery;
import com.simple.keen.system.model.vo.MenuInfoVO;
import com.simple.keen.system.model.vo.MenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/11/21
 */
@Mapper
public interface MenuMapping {

    MenuMapping INSTANCE = Mappers.getMapper(MenuMapping.class);


    List<MenuVO> toMenuVOList(List<MenuDTO> menuDTOS);

    @Mapping(source = "title", target = "meta.title")
    @Mapping(source = "icon", target = "meta.icon")
    @Mapping(source = "breadCrumb", target = "meta.breadCrumb")
    MenuVO toMenuVO(MenuDTO menuDTO);

    MenuInfoVO toMenuInfoVO(Menu menu);

    MenuDTO toMenuDTO(MenuQuery menuQuery);

    MenuDTO toMenuDTO(Menu menu);

    Menu toMenu(MenuDTO menuDTO);

}
