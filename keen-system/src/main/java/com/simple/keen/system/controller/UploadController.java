package com.simple.keen.system.controller;

import com.simple.keen.common.base.Response;
import com.simple.keen.system.service.IUploadService;
import javax.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/27
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/upload")
public class UploadController {

    @Resource
    private IUploadService uploadService;

    @PostMapping("img")
    public Response uploadImg(@RequestParam("file") MultipartFile file) {
        return Response.ok(uploadService.uploadImg(file));
    }
}
