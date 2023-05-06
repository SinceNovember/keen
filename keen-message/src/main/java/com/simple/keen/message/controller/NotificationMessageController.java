package com.simple.keen.message.controller;

import com.simple.keen.common.base.Response;
import com.simple.keen.message.model.query.NotificationMessageQuery;
import com.simple.keen.message.service.INotificationMessageService;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/message/notification")
public class NotificationMessageController {

    private final INotificationMessageService notificationMessageService;

    @GetMapping("page")
    public Response pageNotificationMessage(NotificationMessageQuery notificationMessageQuery) {
        return Response.ok(
            notificationMessageService.pageNotificationMessage(notificationMessageQuery));
    }

    @GetMapping
    public Response getNotificationMessage(@NotNull Integer id) {
        return Response.ok(notificationMessageService.getNotificationMessageById(id));
    }

    @PostMapping
    public Response addOrUpdateNotificationMessage(
        @Validated @RequestBody NotificationMessageQuery notificationMessageQuery) {
        notificationMessageService.addOrUpdateNotificationMessage(notificationMessageQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteNotificationMessage(
        @NotNull @RequestBody NotificationMessageQuery notificationMessageQuery) {
        notificationMessageService.deleteNotificationMessage(notificationMessageQuery.getIds());
        return Response.ok();
    }

}
