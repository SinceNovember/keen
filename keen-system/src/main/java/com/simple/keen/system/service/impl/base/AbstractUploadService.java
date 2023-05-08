package com.simple.keen.system.service.impl.base;

import cn.hutool.core.util.RandomUtil;
import com.simple.keen.common.consts.MsgConsts;
import com.simple.keen.common.exception.KeenException;
import com.simple.keen.common.utils.StringUtils;
import java.time.LocalDate;
import java.util.stream.Stream;
import org.springframework.web.multipart.MultipartFile;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/5/8
 */
public class AbstractUploadService {

    /**
     * 图像类型
     */
    protected static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif",
        ".png"};

    /**
     * 检查图片后缀
     *
     * @param file 文件
     * @return
     */
    protected void checkImgSuffix(MultipartFile file) {
        if (Stream.of(IMAGE_TYPE)
            .noneMatch(
                type -> StringUtils.endWithIgnoreCase(file.getOriginalFilename(), type))) {
            throw new KeenException(MsgConsts.UPLOAD_TYPE_ERROR_MSG);
        }
    }

}
