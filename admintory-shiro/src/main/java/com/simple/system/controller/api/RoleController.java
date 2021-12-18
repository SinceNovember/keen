package com.simple.system.controller.api;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.model.constant.CommonConstant;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.system.model.dto.RoleDTO;
import com.simple.system.model.entity.Role;
import com.simple.system.model.params.RoleParam;
import com.simple.system.model.vo.RoleCondition;
import com.simple.system.service.RoleService;
import com.simple.system.service.UserRoleRelateService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/api/system/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleRelateService userRoleRelateService;

    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取角色列表失败")
    public ResponseData listRole(RoleCondition condition, @RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize){
        IPage<RoleDTO> roleIPage = roleService.pageRole(condition, pageNumber, pageSize);
        return Response.ok(roleIPage);
    }

    @GetMapping
    @ControllerEndpoint(exceptionMessage = "获取角色失败")
    public ResponseData getRole(@NonNull Integer roleId){
        RoleDTO roleDTO = roleService.getRoleDetailById(roleId);
        return Response.ok(roleDTO);
    }

    @GetMapping("/count/member")
    public ResponseData countRoleMember(){
        return Response.ok(roleService.countRoleMemberTop6());
    }

    @PostMapping
    @ControllerEndpoint(operation = "新增角色", exceptionMessage = "新增角色失败")
    public ResponseData addRole(@NonNull @RequestBody RoleParam roleParam){
        Role role = roleParam.convertTo();
        role.setCreateTime(new Date());
        roleService.save(role);
        return Response.ok();
    }

    @PutMapping
    @ControllerEndpoint(operation = "修改角色", exceptionMessage = "修改角色失败")
    public ResponseData updateRole(@NonNull @RequestBody RoleParam roleParam){
        Role role = roleParam.convertTo();
        role.setUpdateTime(new Date());
        roleService.updateById(role);
        return Response.ok();
    }

    @GetMapping("/user/relate")
    @ControllerEndpoint( exceptionMessage = "获取用户角色失败")
    public ResponseData getRoleUserRelate(@NonNull Integer roleId) {
        return Response.ok(userRoleRelateService.listUserIdByRoleId(roleId));
    }

    /**
     * 修改角色与用户的关系
     * @return
     */
    @PutMapping("/user/relate")
    @ControllerEndpoint(operation = "修改角色用户关系", exceptionMessage = "修改角色用户失败")
    public ResponseData updateRoleUserRelate(@NonNull @RequestBody RoleParam roleParam){
        userRoleRelateService.updateRoleUserRelate(roleParam.getRoleId(), roleParam.getUserIdList());
        return Response.ok();
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "删除角色", exceptionMessage = "删除角色失败")
    public ResponseData removeRole(@NonNull  @RequestParam("ids") String ids) {
        roleService.logicDeleteRoleByIds(ids);
        return Response.ok(CommonConstant.DELETE_SUCCESS_TEXT);
    }

    /**
     * 启用/禁用角色
     * @return
     */
    @PutMapping("/status")
    @ControllerEndpoint(operation = "启用/禁用角色", exceptionMessage = "启用/禁用角色失败")
    public ResponseData enableOrDisableRole(@NonNull @RequestBody String str) {
        String ids = JSON.parseObject(str).getString("ids");
        roleService.enableOrDisableRole(ids);
        return Response.ok();
    }

    /**
     * 获取角色下拉选项
     * @return
     */
    @GetMapping("/option")
    @ControllerEndpoint(exceptionMessage = "获取角色下拉选项失败")
    public ResponseData listRoleOption() {
        return Response.ok(roleService.listRoleOption());
    }
}
