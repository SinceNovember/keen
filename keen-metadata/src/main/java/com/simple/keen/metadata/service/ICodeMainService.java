package com.simple.keen.metadata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.base.OptionModel;
import com.simple.keen.metadata.model.entity.CodeMain;
import com.simple.keen.metadata.model.query.CodeMainQuery;
import com.simple.keen.metadata.model.vo.CodeMainVO;
import java.util.List;

public interface ICodeMainService extends IService<CodeMain> {

    /**
     * 分页获取代码项
     *
     * @param roleQuery 代码项查询
     * @return 分页系代码项VO
     */
    PageSerializable<CodeMainVO> pageCodeMain(CodeMainQuery roleQuery);

    /**
     * 通过id获取代码项
     *
     * @param id id
     * @return 代码项VO
     */
    CodeMainVO getCodeMainById(Integer id);

    /**
     * 根据代码名获取对应的下拉形的代码项
     *
     * @param name 名字
     * @return
     */
    List<OptionModel> listOptionModelByCodeName(String name);

    /**
     * 添加或更新代码项
     *
     * @param roleQuery 代码项查询
     */
    void addOrUpdateCodeMain(CodeMainQuery roleQuery);

    /**
     * 删除代码项
     *
     * @param ids id
     */
    void deleteCodeMain(List<Integer> ids);

}
