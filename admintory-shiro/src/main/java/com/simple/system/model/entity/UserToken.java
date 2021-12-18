package com.simple.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_user_token")
public class UserToken {

    //用户ID
    @TableId(type = IdType.INPUT)
    private Integer userId;

    //token
    private String token;

    //过期时间
    private Date expireTime;

    //更新时间
    private Date updateTime;
}
