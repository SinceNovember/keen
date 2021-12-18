package com.simple.other.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@TableName("t_theme")
public class Theme implements Serializable {

    private static final long serialVersionUID = 921991157363932095L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 主题文本
     */
    @TableField("theme_text")
    private String themeText;

    /**
     * 主题名
     */
    @TableField("theme_name")
    private String themeName;

    /**
     * 主题图片地址
     */
    @TableField("pic_url")
    private String picUrl;

    /**
     * 排序号
     */
    @TableField("order_num")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

}
