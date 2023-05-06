package com.simple.keen.metadata.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.base.OptionModel;
import com.simple.keen.common.utils.PageHelperUtils;
import com.simple.keen.metadata.mapper.CodeMainMapper;
import com.simple.keen.metadata.mapping.CodeMainMapping;
import com.simple.keen.metadata.model.dto.CodeMainDTO;
import com.simple.keen.metadata.model.entity.CodeMain;
import com.simple.keen.metadata.model.query.CodeMainQuery;
import com.simple.keen.metadata.model.vo.CodeMainVO;
import com.simple.keen.metadata.service.ICodeMainService;
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
public class CodeMainServiceImpl extends
    ServiceImpl<CodeMainMapper, CodeMain> implements
    ICodeMainService {

    @Override
    public PageSerializable<CodeMainVO> pageCodeMain(CodeMainQuery codeMainQuery) {
        PageHelperUtils.startPage(codeMainQuery);
        List<CodeMainDTO> codeMainDTOS = baseMapper.selectCodeMainList(codeMainQuery);

        return PageHelperUtils.convertPageDto2Vo(codeMainDTOS,
            CodeMainMapping.INSTANCE::toCodeMainVOList);
    }

    @Override
    public CodeMainVO getCodeMainById(Integer id) {
        return CodeMainMapping.INSTANCE.toCodeMainVO(getById(id));
    }

    @Override
    public List<OptionModel> listOptionModelByCodeName(String name) {
        return baseMapper.selectCodeMainAsModelListByCodeName(name);
    }

    @Override
    public void addOrUpdateCodeMain(CodeMainQuery codeMainQuery) {
        CodeMainDTO codeMainDTO = CodeMainMapping.INSTANCE.toCodeMainDTO(codeMainQuery);
        if (codeMainQuery.getId() == null) {
            codeMainDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(CodeMainMapping.INSTANCE.toCodeMain(codeMainDTO));
    }

    @Override
    public void deleteCodeMain(List<Integer> ids) {
        remove(Wrappers.<CodeMain>lambdaUpdate()
            .in(CodeMain::getId, ids));
    }
}
