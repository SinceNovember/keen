package com.simple.keen.attachment.controller;

import com.simple.keen.attachment.service.IAttachmentService;
import com.simple.keen.common.base.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/5/25
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attachment")
public class AttachmentController {

    private final IAttachmentService attachmentService;

    @PostMapping("upload")
    public Response uploadAttachment(@RequestParam("file") MultipartFile file) {
        return Response.ok(attachmentService.uploadAttachment(file));
    }

    @PostMapping("uploadImage")
    public Response uploadImage(@RequestParam("file") MultipartFile file) {
        return Response.ok(attachmentService.uploadImage(file));
    }

    @GetMapping("download")
    public void downloadAttachment(@RequestParam("attachmentId") Integer attachmentId) {
        attachmentService.downloadAttachment(attachmentId);
    }

}
