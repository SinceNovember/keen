package com.simple.keen.system.service;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    /**
     * 上传文件
     *
     * @param file 文件
     * @return 图标上传后的下载地址
     */
    String uploadImg(MultipartFile file);

//    /**
//     * 上传文件
//     *
//     * @param inputStream 输入流
//     * @param name        名字
//     * @return
//     */
//    String uploadFile(InputStream inputStream, String name);
}
