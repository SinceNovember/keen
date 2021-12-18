package com.simple.metadata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableMap;
import com.simple.common.utils.StringUtils;
import com.simple.metadata.dao.CodeItemMapper;
import com.simple.metadata.model.dto.CodeItemDTO;
import com.simple.metadata.model.entity.CodeItem;
import com.simple.metadata.model.vo.CodeItemCondition;
import com.simple.metadata.service.CodeItemService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CodeItemServiceImpl extends ServiceImpl<CodeItemMapper, CodeItem> implements CodeItemService {

    @Resource
    private CodeItemMapper codeItemMapper;
    
    @Override
    public IPage<CodeItemDTO> pageCodeItem(CodeItemCondition condition, int pageIndex, int pageSize) {
        LambdaQueryWrapper<CodeItem> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StringUtils.isNotEmpty(condition.getItemText()), CodeItem::getItemText, condition.getItemText())
                .eq(Objects.nonNull(condition.getCodeId()), CodeItem::getCodeId, condition.getCodeId())
                .orderByDesc(CodeItem::getOrderNum);

        Page<CodeItem> page = new Page<>(pageIndex, pageSize);
        IPage<CodeItemDTO> configIPage = page(page, queryWrapper).convert(this::convertTo);
        return configIPage;
    }

    @Override
    public void removeCodeItemByCodeId(Long codeId) {
        LambdaQueryWrapper<CodeItem> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(CodeItem::getCodeId, codeId);
        this.remove(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listCodeItemMapByCodeName(String codeName) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        List<CodeItemDTO> codeItemList = codeItemMapper.listCodeItemByCodeName(codeName);
        codeItemList.forEach(codeItemDTO -> {
            Map<String, Object> map = ImmutableMap.of("label", codeItemDTO.getItemText(), "value", codeItemDTO.getItemValue());
            dataList.add(map);
        });
        return dataList;
    }

    @Override
    public CodeItemDTO convertTo(CodeItem codeItem) {
        Assert.notNull(codeItem, "codeItem must not be null");
        return new CodeItemDTO().covertFrom(codeItem);
    }

    @Override
    public List<CodeItemDTO> convertTo(List<CodeItem> codeItems) {
        if (CollectionUtils.isEmpty(codeItems)) {
            return Collections.emptyList();
        }
        return codeItems.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }
}
