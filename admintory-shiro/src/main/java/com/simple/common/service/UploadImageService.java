package com.simple.common.service;

import java.io.FileInputStream;

/**
 * 上传图片Service
 */
public interface UploadImageService {

    public String uploadImg(FileInputStream file, String path);
}
