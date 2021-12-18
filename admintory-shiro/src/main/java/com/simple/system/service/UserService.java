package com.simple.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.system.model.dto.MenuDTO;
import com.simple.system.model.dto.UserDTO;
import com.simple.system.model.entity.Menu;
import com.simple.system.model.entity.User;
import com.simple.system.model.params.PasswordParam;
import com.simple.system.model.params.UserParam;
import com.simple.system.model.vo.UserCondition;

import java.util.List;

public interface UserService extends IService<User> {

     IPage<UserDTO> pageUser(UserCondition userCondition, int pageIndex, int pageSize);

     UserDTO getUserDetailById(int id);

     User getUserByUsername(String username);

     UserDTO getUserDetailByToken(String token);

     /**
      * 获取在线
      * @return
      */
     List<UserDTO> listOnlineUser(Integer userId);

     void saveUser(UserParam userParam);

     void updateUser(UserParam userParam);

     void updateUserDept(UserParam userParam);

     void logicDeleteUserByIds(String ids);

     void enableOrDisableUser(String ids);

     void updatePassword(PasswordParam passwordParam);

     void resetPassword(Integer userId);

     String getUserAvatar(String userId);

     UserDTO convertTo(User menu) ;

     List<UserDTO> convertTo(List<User> menus) ;
}
