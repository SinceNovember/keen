package com.simple.system.service;

import com.simple.monitor.model.entity.ActiveUser;
import com.simple.system.model.dto.UserDTO;

import java.util.Map;

public interface UserTokenService  {

    Map<String, Object> createToken(Integer userId);

    default void createTokenSessionRelate(String token, String session){};

    Integer verityUserToken(String accessToken);

    UserDTO getUserByToken(String token);

    void clearToken(ActiveUser activeUser, String token);


}
