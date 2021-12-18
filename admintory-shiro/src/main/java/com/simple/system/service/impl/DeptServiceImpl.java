package com.simple.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.common.exception.RelateExistException;
import com.simple.system.dao.DeptMapper;
import com.simple.system.model.dto.DeptDTO;
import com.simple.system.model.dto.DeptTreeDTO;
import com.simple.system.model.dto.OptionDTO;
import com.simple.system.model.entity.Dept;
import com.simple.system.model.vo.DeptCondition;
import com.simple.system.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeptServiceImpl  extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public IPage<DeptDTO> pageDept(DeptCondition deptCondition, int pageIndex, int pageSize) {
        IPage<DeptDTO> deptIPage = new Page<>();
        deptIPage.setRecords(deptMapper.listDeptWithMember(deptCondition, (pageIndex - 1) * pageSize, pageSize));
        deptIPage.setTotal(deptMapper.countDept(deptCondition));
        return deptIPage;
    }

    @Override
    public DeptDTO getDeptDetailById(int id) {
        return deptMapper.getDeptWithMemberById(id);
    }

    @Override
    public List<Map<String, Integer>> countDeptMemberTop6() {
        return deptMapper.countDeptMember().stream().limit(6).collect(Collectors.toList());
    }

    @Override
    public void logicDeleteDeptByIds(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        idList.forEach(id -> {
            logicDeleteDeptById(Integer.valueOf(id));
        });
    }

    public void logicDeleteDeptById(int id) {
        DeptDTO deptDTO = deptMapper.getDeptWithMemberById(id);
        if (!CollectionUtils.isEmpty(deptDTO.getMemberList())) {
            throw new RelateExistException("部门下存在用户");
        }

        if (!CollectionUtils.isEmpty(deptDTO.getChildren())) {
            throw new RelateExistException("部门下存在子部门");
        }

        Dept dept = deptMapper.selectById(id);
        if (null != dept) {
            dept.setDeleted(true);
            deptMapper.updateById(dept);
        }

    }

    /**
     * 获取部门下拉选项
     * @return
     */
    @Override
    public List<OptionDTO> listDeptOption() {
        return deptMapper.listDeptOptionByParentId(0);
    }

    /**
     * 获取部门用户树
     * @return
     */
    @Override
    public List<DeptTreeDTO> listDeptWithUserTree() {
        List<DeptTreeDTO> treeList = deptMapper.listDeptWithUserTreeModelByParentId(0);
        return treeList;
    }

    @Override
    public DeptDTO convertTo(Dept dept) {
        Assert.notNull(dept, "dept must not be null");
        return new DeptDTO().covertFrom(dept);
    }

    @Override
    public List<DeptDTO> convertTo(List<Dept> depts) {
        if (CollectionUtils.isEmpty(depts)) {
            return Collections.emptyList();
        }

        return depts.stream()
                .map(this::convertTo)
                .collect(Collectors.toList());
    }
}
