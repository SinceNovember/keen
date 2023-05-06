package com.simple.keen.metadata.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.utils.PageHelperUtils;
import com.simple.keen.metadata.mapper.CodeItemMapper;
import com.simple.keen.metadata.mapping.CodeItemMapping;
import com.simple.keen.metadata.model.dto.CodeItemDTO;
import com.simple.keen.metadata.model.entity.CodeItem;
import com.simple.keen.metadata.model.query.CodeItemQuery;
import com.simple.keen.metadata.model.vo.CodeItemVO;
import com.simple.keen.metadata.service.ICodeItemService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/4
 */

@Service
@RequiredArgsConstructor
public class CodeItemServiceImpl extends
    ServiceImpl<CodeItemMapper, CodeItem> implements
    ICodeItemService {

    @Override
    public PageSerializable<CodeItemVO> pageCodeItem(CodeItemQuery codeItemQuery) {
        PageHelperUtils.startPage(codeItemQuery);
        List<CodeItemDTO> codeItemDTOS = baseMapper.selectCodeItemList(
            codeItemQuery);

        return PageHelperUtils.convertPageDto2Vo(codeItemDTOS,
            CodeItemMapping.INSTANCE::toCodeItemVOList);
    }

    @Override
    public void addOrUpdateCodeItem(CodeItemQuery codeItemQuery) {
        CodeItemDTO codeItemDTO = CodeItemMapping.INSTANCE.toCodeItemDTO(
            codeItemQuery);
        if (codeItemQuery.getId() == null) {
            codeItemDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(CodeItemMapping.INSTANCE.toCodeItem(codeItemDTO));
    }

    @Override
    public CodeItemVO getCodeItemById(Integer id) {
        return CodeItemMapping.INSTANCE.toCodeItemVO(getById(id));
    }

    @Override
    public void deleteCodeItem(List<Integer> ids) {
        remove(Wrappers.<CodeItem>lambdaUpdate()
            .in(CodeItem::getId, ids));
    }
}
