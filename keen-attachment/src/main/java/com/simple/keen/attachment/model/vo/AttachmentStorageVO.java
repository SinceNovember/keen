package com.simple.keen.attachment.model.vo;

import com.simple.keen.attachment.model.enums.AttachmentUploadPlatformType;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/5/10
 */
@Data
@Builder
@ToString
public class AttachmentStorageVO {

    private String uploadUrl;

    private AttachmentUploadPlatformType uploadPlatformType;

}
