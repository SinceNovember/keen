package com.simple.keen.message.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.keen.message.model.enums.ChatMessageContentType;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/18
 */
@Data
@ToString
public class ChatMessageVO {

    /**
     * id
     */
    private Integer id;

    /**
     * 发送端
     */

    private String from;

    /**
     * 内容
     */
    private String content;

    /**
     * 内容类型
     */
    private ChatMessageContentType contentType;

    /**
     * 时间线
     */
    private String timeLine;

    /**
     * 创建时间
     */
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
