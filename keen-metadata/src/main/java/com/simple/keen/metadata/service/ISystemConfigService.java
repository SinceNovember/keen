package com.simple.keen.metadata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.metadata.model.entity.SystemConfig;
import com.simple.keen.metadata.model.query.SystemConfigQuery;
import com.simple.keen.metadata.model.vo.SystemConfigVO;
import java.util.List;

public interface ISystemConfigService extends IService<SystemConfig> {

    /**
     * 分页获取系统参数
     *
     * @param roleQuery 系统参数查询
     * @return 分页系统参数VO
     */
    PageSerializable<SystemConfigVO> pageSystemConfig(SystemConfigQuery roleQuery);

    /**
     * 添加或更新系统参数
     *
     * @param roleQuery 系统参数查询
     */
    void addOrUpdateSystemConfig(SystemConfigQuery roleQuery);

    /**
     * 通过id获取系统参数
     *
     * @param id id
     * @return 系统参数VO
     */
    SystemConfigVO getSystemConfigById(Integer id);

    /**
     * 根据名称获取配置值
     *
     * @param configName 配置名称
     * @return
     */
    String getConfigValueByName(String configName);


    /**
     * 删除系统参数
     *
     * @param ids id
     */
    void deleteSystemConfig(List<Integer> ids);

}
