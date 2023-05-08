package com.simple.keen.system.service.impl;

import com.simple.keen.system.service.IUploadService;
import com.simple.keen.system.service.impl.base.AbstractUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/5/8
 */
@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnMissingBean(AliyunOSSUploadServiceImpl.class)
public class DatabaseUploadServiceImpl extends AbstractUploadService implements IUploadService {

    @Override
    public String uploadImg(MultipartFile file) {
        return null;
    }
}
