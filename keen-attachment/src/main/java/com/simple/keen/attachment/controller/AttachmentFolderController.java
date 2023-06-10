package com.simple.keen.attachment.controller;

import com.simple.keen.attachment.model.query.AttachmentFolderAndInfoQuery;
import com.simple.keen.attachment.service.IAttachmentFolderService;
import com.simple.keen.common.base.Response;
import javax.validation.constraints.NotNull;
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
 * @date 2023/6/3
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attachment/folder")
public class AttachmentFolderController {

    private final IAttachmentFolderService attachmentFolderService;

    @PostMapping
    public Response addOrUpdateAttachmentFolder(@RequestBody AttachmentFolderAndInfoQuery query) {
        attachmentFolderService.addOrUpdateAttachmentFolder(query);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteAttachmentFolder(@NotNull @RequestBody AttachmentFolderAndInfoQuery query) {
        attachmentFolderService.recursiveDeleteFolderAndAttachment(query.getIds());
        return Response.ok();
    }

}
