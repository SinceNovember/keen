package com.simple.keen.attachment.model.vo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/6/1
 */
@Data
@Builder
@ToString
public class AttachmentUploadVO {

    private Integer id;

    private String url;

}
