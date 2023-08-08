package com.simple.keen.attachment.model.enums;

import com.simple.keen.common.base.enums.ValueEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 附件上传平台类型
 *
 * @author SinceNovember
 * @date 2023/08/07
 */
@Getter
@AllArgsConstructor
public enum AttachmentUploadPlatformType implements ValueEnum<Integer> {

    DATABASE(1, "数据库存储"),
    ALIYUN(2, "阿里云存储");

    private final Integer code;
    private final String msg;


    @Override
    public Integer getValue() {
        return code;
    }
}
