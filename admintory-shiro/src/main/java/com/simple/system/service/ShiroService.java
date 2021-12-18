package com.simple.system.service;

import com.simple.system.model.entity.User;
import com.simple.system.model.entity.UserToken;

public interface ShiroService {

    UserToken getUserToken(String accessToken);

    User getUser(Integer userId);
}
