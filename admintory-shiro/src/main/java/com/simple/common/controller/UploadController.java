package com.simple.common.controller;

import com.simple.common.model.entity.ResponseData;
import com.simple.common.service.UploadImageService;
import com.simple.common.model.entity.Response;
import com.simple.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import static com.simple.common.model.constant.CommonConstant.*;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Resource
    UploadImageService uploadImageService;

    @PostMapping(value = "/image")
    public ResponseData upLoadImage(@RequestParam("file") MultipartFile file) {

        // 获取文件的名称
        String fileName = file.getOriginalFilename();

        // 使用工具类根据上传文件生成唯一图片名称
        String imgName = StringUtils.getRandomImgName(fileName);

        if (!file.isEmpty()) {
            try {
                FileInputStream inputStream = (FileInputStream) file.getInputStream();
                String path = uploadImageService.uploadImg(inputStream, imgName);
                log.info("七牛云返回的图片链接:{}", path);
                return Response.ok(path, UPLOAD_SUCCESS_TEXT);
            } catch (IOException e){
                log.error(UPLOAD_FAIL_TEXT, e);
                return Response.fail(UPLOAD_FAIL_TEXT);
            }
        }
        return Response.fail(UPLOAD_EMPTY_TEXT);
    }

}
