package com.simple.keen.message.controller;

import com.simple.keen.common.base.Response;
import com.simple.keen.message.model.query.ChatMessagePageQuery;
import com.simple.keen.message.model.query.ChatMessageQuery;
import com.simple.keen.message.service.IChatMessageService;
import com.simple.keen.message.service.IChatMessageUserHiddenService;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/18
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/message/chat")
public class ChatMessageController {

    private final IChatMessageService chatMessageService;

    private final IChatMessageUserHiddenService chatMessageUserHiddenService;

    @GetMapping("page")
    public Response pageRole(ChatMessagePageQuery query) {
        return Response.ok(chatMessageService.pageChatMessage(query));
    }

    @GetMapping("contactUser")
    public Response contactUser() {
        return Response.ok(chatMessageService.listContactUserAndChatMessage());
    }

    @PostMapping("contactUser/hidden")
    public Response hiddenContactUser(@RequestBody ChatMessageQuery query) {
        chatMessageUserHiddenService.addContactUserHidden(query);
        return Response.ok();
    }

    @PostMapping("contactUser/show")
    public Response showContactUser(@RequestBody ChatMessageQuery query) {
        chatMessageUserHiddenService.deleteContactUserHidden(query);
        return Response.ok();
    }

    @PutMapping("unread/clear")
    public Response clearUnreadChatMessage(@RequestBody ChatMessageQuery query) {
        chatMessageService.clearUnreadChatMessage(query);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteChatMessage(@NotNull @RequestBody ChatMessagePageQuery query) {
        chatMessageService.deleteChatMessage(query.getIds());
        return Response.ok();
    }

}
