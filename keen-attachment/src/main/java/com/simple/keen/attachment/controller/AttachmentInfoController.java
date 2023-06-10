package com.simple.keen.attachment.controller;

import com.simple.keen.attachment.model.query.AttachmentFolderAndInfoQuery;
import com.simple.keen.attachment.service.IAttachmentInfoService;
import com.simple.keen.common.base.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/6/9
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attachment/info")
public class AttachmentInfoController {

    private final IAttachmentInfoService attachmentInfoService;

    @GetMapping("page")
    public Response pageFolderAndAttachmentInfo(AttachmentFolderAndInfoQuery query) {
        return Response.ok(attachmentInfoService.pageAttachmentFolderAndInfo(query));
    }

    @GetMapping("summary")
    public Response getAttachmentInfoSummary() {
        return Response.ok(attachmentInfoService.countItemAndSumStorageSize());
    }

    @PostMapping
    public Response addOrUpdateAttachmentFolder(@RequestBody AttachmentFolderAndInfoQuery query) {
        attachmentInfoService.addOrUpdateAttachmentInfo(query);
        return Response.ok();
    }

}
