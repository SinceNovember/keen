package com.simple.keen.monitor.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Data
@ToString
public class OperateLogVO {

    /**
     * 日志ID
     */
    private Integer id;

    /**
     * 操作用户
     */
    private String nickname;

    /**
     * 操作内容
     */
    private String operation;

    /**
     * 耗时
     */
    private Long time;

    /**
     * 操作方法
     */
    private String method;

    /**
     * 方法参数
     */
    private String params;

    /**
     * 操作者IP
     */
    private String ip;

    /**
     * 操作时间
     */
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operateTime;

    /**
     * 操作地点
     */
    private String location;

}
