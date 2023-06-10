package com.simple.keen.attachment.model.dto;

import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/6/9
 */
@Data
@ToString
public class AttachmentInfoSummaryDTO {

    private int itemCount;

    private long storageSize;

    private String formatStorageSize;


}
