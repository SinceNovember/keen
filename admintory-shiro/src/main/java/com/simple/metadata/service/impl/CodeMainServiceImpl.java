package com.simple.metadata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.common.exception.AdmintoryException;
import com.simple.common.utils.StringUtils;
import com.simple.metadata.dao.CodeMainMapper;
import com.simple.metadata.model.dto.CodeMainDTO;
import com.simple.metadata.model.entity.CodeMain;
import com.simple.metadata.model.vo.CodeMainCondition;
import com.simple.metadata.service.CodeItemService;
import com.simple.metadata.service.CodeMainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CodeMainServiceImpl extends ServiceImpl<CodeMainMapper, CodeMain> implements CodeMainService {

    @Resource
    private CodeItemService codeItemService;

    @Override
    public IPage<CodeMainDTO> pageCodeMain(CodeMainCondition condition, int pageIndex, int pageSize) {
        LambdaQueryWrapper<CodeMain> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StringUtils.isNotEmpty(condition.getCodeName()), CodeMain::getCodeName, condition.getCodeName())
                .like(StringUtils.isNotEmpty(condition.getDescription()), CodeMain::getDescription, condition.getDescription())
                .orderByDesc(CodeMain::getOrderNum);

        Page<CodeMain> page = new Page<>(pageIndex, pageSize);
        IPage<CodeMainDTO> configIPage = page(page, queryWrapper).convert(this::convertTo);
        return configIPage;
    }

    @Override
    @Transactional(rollbackFor = AdmintoryException.class)
    public void removeCodeMainWithItem(Set<String> codeIdList) {
        codeIdList.forEach(codeId -> {
            this.removeById(codeId);
            codeItemService.removeCodeItemByCodeId(Long.valueOf(codeId));
        });
    }

    @Override
    public CodeMainDTO convertTo(CodeMain codeMain) {
        Assert.notNull(codeMain, "codeMain must not be null");
        return new CodeMainDTO().covertFrom(codeMain);
    }

    @Override
    public List<CodeMainDTO> convertTo(List<CodeMain> codeMains) {
        if (CollectionUtils.isEmpty(codeMains)) {
            return Collections.emptyList();
        }
        return codeMains.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }
}
