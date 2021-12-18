package com.simple.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.system.model.dto.DeptDTO;
import com.simple.system.model.dto.DeptTreeDTO;
import com.simple.system.model.dto.OptionDTO;
import com.simple.system.model.dto.TreeDTO;
import com.simple.system.model.entity.Dept;
import com.simple.system.model.entity.User;
import com.simple.system.model.vo.DeptCondition;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface DeptService  extends IService<Dept> {

    IPage<DeptDTO> pageDept(DeptCondition deptCondition, int pageIndex, int pageSize);

    DeptDTO getDeptDetailById(int id);

    List<Map<String, Integer>> countDeptMemberTop6();

    void logicDeleteDeptByIds(String ids);

    void logicDeleteDeptById(int id);

    List<OptionDTO> listDeptOption();

    List<DeptTreeDTO> listDeptWithUserTree();

    DeptDTO convertTo(Dept dept) ;

    List<DeptDTO> convertTo(List<Dept> depts) ;


}
