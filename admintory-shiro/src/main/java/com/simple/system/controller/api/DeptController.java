package com.simple.system.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.model.constant.CommonConstant;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.system.model.dto.DeptDTO;
import com.simple.system.model.dto.DeptTreeDTO;
import com.simple.system.model.entity.Dept;
import com.simple.system.model.params.DeptParam;
import com.simple.system.model.vo.DeptCondition;
import com.simple.system.service.DeptService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/system/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取部门列表失败")
    public ResponseData listDept(DeptCondition condition, @RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize){
        IPage<DeptDTO> deptIPage = deptService.pageDept(condition, pageNumber, pageSize);
        return Response.ok(deptIPage);
    }

    @GetMapping
    @ControllerEndpoint(exceptionMessage = "获取部门失败")
    public ResponseData getDept(@NonNull Integer deptId){
        DeptDTO deptDTO = deptService.getDeptDetailById(deptId);
        return Response.ok(deptDTO);
    }

    @GetMapping("/user/tree")
    @ControllerEndpoint(exceptionMessage = "新增部门用户树失败")
    public ResponseData getDeptWithUserTree(){
        List<DeptTreeDTO> treeModel = deptService.listDeptWithUserTree();
        return Response.ok(treeModel);
    }

    /**
     * 获取部门-成员数前6
     * @return
     */
    @GetMapping("/count/member")
    public ResponseData countDeptMember(){
        return Response.ok(deptService.countDeptMemberTop6());
    }

    @PostMapping
    @ControllerEndpoint(operation = "新增部门", exceptionMessage = "新增部门失败")
    public ResponseData addDept(@RequestBody DeptParam deptParam){
        Dept dept = deptParam.convertTo();
        dept.setCreateTime(new Date());
        dept.setCreateUserId(1);
        deptService.save(dept);
        return Response.ok();
    }

    @PutMapping
    @ControllerEndpoint(operation = "修改部门", exceptionMessage = "修改部门失败")
    public ResponseData updateDept(@RequestBody DeptParam deptParam){
        Dept dept = deptParam.convertTo();
        dept.setUpdateTime(new Date());
        deptService.updateById(dept);
        return Response.ok();
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "删除部门", exceptionMessage = "删除部门失败")
    public ResponseData removeDept(@NonNull @RequestParam("id") Integer id) {
        deptService.logicDeleteDeptById(id);
        return Response.ok(CommonConstant.DELETE_SUCCESS_TEXT);
    }

    /**
     * 获取部门下拉选项
     * @return
     */
    @GetMapping("/option")
    @ControllerEndpoint(exceptionMessage = "获取部门下拉选项失败")
    public ResponseData listDeptOption() {
        return Response.ok(deptService.listDeptOption());
    }

}
