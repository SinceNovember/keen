package com.simple.common.service.impl;

import com.simple.common.service.UploadImageService;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;


@Service
public class DefaultUploadImageServiceImpl implements UploadImageService {
    @Override
    public String uploadImg(FileInputStream file, String path) {
        System.out.println("使用了默认的上传图片");
        return null;
    }
}
