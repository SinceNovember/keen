package com.simple.keen.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.keen.common.base.TreeModel;
import com.simple.keen.common.consts.Consts;
import com.simple.keen.common.utils.OnlineUtils;
import com.simple.keen.common.utils.PageHelperUtils;
import com.simple.keen.system.mapper.DeptMapper;
import com.simple.keen.system.mapping.DeptMapping;
import com.simple.keen.system.model.dto.DeptDTO;
import com.simple.keen.system.model.entity.Dept;
import com.simple.keen.system.model.query.DeptQuery;
import com.simple.keen.system.model.vo.DeptVO;
import com.simple.keen.system.model.vo.DeptWithUserVO;
import com.simple.keen.system.service.IDeptService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Override
    public PageSerializable<DeptVO> pageDept(DeptQuery deptQuery) {
        PageHelperUtils.startPage(deptQuery);
        return PageHelperUtils.convertPageDto2Vo(baseMapper.selectDeptList(deptQuery),
            DeptMapping.INSTANCE::toDeptVOList);
    }

    @Override
    public List<DeptWithUserVO> listDeptWithUser(DeptQuery deptQuery) {
        List<DeptDTO> deptDTOS = baseMapper.selectDeptList(null);
        //设置部门用户在线状态
        recursiveDeptUserOnline(deptDTOS);
        return DeptMapping.INSTANCE.toDeptWithUserVOList(deptDTOS);
    }

    private void recursiveDeptUserOnline(List<DeptDTO> deptDTOS) {
        deptDTOS.forEach(deptDTO -> {
            deptDTO.getUsers().forEach(
                user -> user.setOnline(OnlineUtils.isOnline(user.getId())));
            if (CollectionUtil.isNotEmpty(deptDTO.getChildren())) {
                recursiveDeptUserOnline(deptDTO.getChildren());
            }
        });
    }

    @Override
    public void addOrUpdateDept(DeptQuery deptQuery) {
        DeptDTO deptDTO = DeptMapping.INSTANCE.toDeptDTO(deptQuery);
        deptDTO.setUpdateTime(LocalDateTime.now());
        if (deptQuery.getId() == null) {
            deptDTO.setCreateUserId(StpUtil.getLoginIdAsInt());
            deptDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(DeptMapping.INSTANCE.toDept(deptDTO));
    }

    @Override
    public DeptVO getDeptById(Integer id) {
        DeptVO deptVO = DeptMapping.INSTANCE.toDeptVO(getById(id));
        Optional.ofNullable(deptVO.getParentId())
            .ifPresent(parentId -> deptVO.setParentName(getById(parentId).getDeptName()));
        return deptVO;

    }

    @Override
    public List<TreeModel> listDeptTreeModel() {
        return baseMapper.selectDeptTreeModelList(Consts.ROOT_PID);
    }

    @Override
    public void deleteDept(List<Integer> ids) {
        update(Wrappers.<Dept>lambdaUpdate()
            .set(Dept::getDeleted, true)
            .in(Dept::getId, ids));
    }

}
