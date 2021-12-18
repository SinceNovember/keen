package com.simple.chat.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple.chat.model.enums.MsgReadType;
import com.simple.chat.model.enums.MsgType;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 历史消息
 */
@Data
@ToString
@TableName("t_msg")
public class MsgHistory {

    @Id
    @TableId(value = "id")
    private String id;

    @TableField("from_id")
    private String fromId;

    @TableField("to_id")
    private String toId;

    @TableField("content")
    private String content;

    @TableField("create_time")
    private Date createTime;

    @TableField("type")
    private MsgType type;

    @TableField("is_read")
    private MsgReadType isRead;


}