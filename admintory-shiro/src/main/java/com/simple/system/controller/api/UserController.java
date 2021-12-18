package com.simple.system.controller.api;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.simple.common.annotation.ControllerEndpoint;
import com.simple.common.controller.AbstractController;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import com.simple.system.model.dto.UserDTO;
import com.simple.system.model.params.PasswordParam;
import com.simple.system.model.params.UserParam;
import com.simple.system.model.vo.UserCondition;
import com.simple.system.service.UserRoleRelateService;
import com.simple.system.service.UserService;
import com.simple.system.service.UserTokenService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/system/user")
public class UserController extends AbstractController {

    @Resource
    private UserService userService;

    @Resource
    private UserRoleRelateService userRoleRelateService;

    @Resource
    private UserTokenService userTokenService;

    @GetMapping("/list")
    @ControllerEndpoint(exceptionMessage = "获取用户列表失败")
    public ResponseData listUser(UserCondition condition, @RequestParam(defaultValue = "1",value = "currentPage") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize){
        IPage<UserDTO> userIPage = userService.pageUser(condition, pageNumber, pageSize);
        return Response.ok(userIPage);
    }

    @GetMapping
    @ControllerEndpoint(exceptionMessage = "获取用户失败")
    public ResponseData getUser(@NonNull Integer userId){
        UserDTO userDTO = userService.getUserDetailById(userId);
        return Response.ok(userDTO);
    }


    @GetMapping("/token")
    @ControllerEndpoint(exceptionMessage = "获取用户失败")
    public ResponseData getUserByToken(@NonNull String token) {
        UserDTO userDTO = userTokenService.getUserByToken(token);
        return Response.ok(userDTO);
    }

    /**
     * 获取当前登陆的用户信息
     * @return
     */
    @GetMapping("/current")
    @ControllerEndpoint(exceptionMessage = "获取当前登陆用户信息失败")
    public ResponseData getCurrentUser(){
        UserDTO userDTO = userService.getUserDetailById(getUserId());
        return Response.ok(userDTO);
    }

    @GetMapping("/online")
    @ControllerEndpoint(exceptionMessage = "获取当前登陆用户信息失败")
    public ResponseData listOnlineUser(){
        List<UserDTO> userList = userService.listOnlineUser(getUserId());
        return Response.ok(userList);
    }


    @PostMapping
    @ControllerEndpoint(operation = "新增用户", exceptionMessage = "新增用户失败")
    public ResponseData addUser(@RequestBody UserParam userParam){
        userService.saveUser(userParam);
        return Response.ok();
    }

    @PutMapping
    @ControllerEndpoint(operation = "修改用户", exceptionMessage = "修改用户失败")
    public ResponseData updateUser(@NonNull @RequestBody UserParam userParam){
        userService.updateUser(userParam);
        return Response.ok();
    }

    @PutMapping("/dept")
    @ControllerEndpoint(operation = "修改用户部门", exceptionMessage = "修改用户部门失败")
    public ResponseData updateUserDept(@NonNull @RequestBody UserParam userParam){
        userService.updateUserDept(userParam);
        return Response.ok();
    }

    /**
     * 修改密码
     * @param
     * @return
     */
    @PutMapping("/password")
    @ControllerEndpoint(operation = "修改密码", exceptionMessage = "修改密码失败")
    public ResponseData updatePassword(@NonNull @RequestBody PasswordParam passwordParam){
        passwordParam.setUserId(this.getUserId());
        userService.updatePassword(passwordParam);
        return Response.ok();
    }

    /**
     * 重置密码
     * @param userId
     * @return
     */
    @PutMapping("/password/reset")
    @ControllerEndpoint(operation = "重置密码", exceptionMessage = "重置密码失败")
    public ResponseData resetPassword(@NonNull @RequestBody String userId){
        userService.resetPassword(Integer.valueOf(userId));
        return Response.ok();
    }

    @DeleteMapping
    @ControllerEndpoint(operation = "删除用户", exceptionMessage = "删除用户失败")
    public ResponseData removeUser(@NonNull @RequestParam("ids") String ids) {
        userService.logicDeleteUserByIds(ids);
        return Response.ok();
    }

    /**
     * 启用/禁用用户
     * @return
     */
    @PutMapping("/status")
    @ControllerEndpoint(operation = "启用/禁用用户", exceptionMessage = "启用/禁用用户失败")
    public ResponseData enableOrDisableUser(@NonNull @RequestBody String str) {
        String ids = JSON.parseObject(str).getString("ids");
        userService.enableOrDisableUser(ids);
        return Response.ok();
    }

    /**
     * 获取角色与用户的关系
     * @return
     */
    @GetMapping("/role/relate")
    @ControllerEndpoint( exceptionMessage = "获取用户角色失败")
    public ResponseData getUserRoleRelate(@NonNull Integer userId) {
        return Response.ok(userRoleRelateService.listRoleIdByUserId(userId));
    }


    /**
     * 修改用户与角色的关系
     * @return
     */
    @PutMapping("/role/relate")
    @ControllerEndpoint(operation = "修改用户角色关系", exceptionMessage = "修改用户角色失败")
    public ResponseData updateUserRoleRelate(@NonNull @RequestBody UserParam userParam){
        userRoleRelateService.updateUserRoleRelate(userParam.getUserId(), userParam.getRoleId());
        return Response.ok();
    }

}
