package com.simple.chat.controller.api;

import com.alibaba.fastjson.JSON;
import com.simple.chat.model.dto.MsgHistoryDTO;
import com.simple.chat.model.dto.RelateMsgUserDTO;
import com.simple.chat.service.MsgHistoryService;
import com.simple.common.controller.AbstractController;
import com.simple.common.model.entity.Response;
import com.simple.common.model.entity.ResponseData;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 历史消息Controller
 */
@RestController
@RequestMapping("/api/msg")
public class MsgHistoryController extends AbstractController {

    @Resource
    private MsgHistoryService msgHistoryService;

    /**
     * 获取指定用户的消息历史
     *
     * @param toId
     * @return
     */
    @GetMapping("/history")
    public ResponseData msgHistory(Integer toId) {
        List<MsgHistoryDTO> msgHistories = msgHistoryService.listMsgHistory(getUserId(), toId);
        return Response.ok(msgHistories);
    }

    /**
     * 获取有关联信息的用户列表及信息列表
     *
     * @return
     */
    @GetMapping("/relate/user")
    public ResponseData relateUser() {
        List<RelateMsgUserDTO> relateUserList = msgHistoryService.listUserRelateMsgUser(getUserId());
        return Response.ok(relateUserList);
    }

    /**
     * 获取所有未读的消息
     *
     * @return
     */
    @GetMapping("/unread/all")
    public ResponseData getAllUnreadMsg() {
        return Response.ok(msgHistoryService.listAllUnreadMsg(getUserId()));
    }

    /**
     * 所有未读消息总数
     *
     * @return
     */
    @GetMapping("/unread/count")
    public ResponseData countAllUnreadMsgCount() {
        int count = msgHistoryService.countAllUnreadMsg(getUserId());
        return Response.ok(count);
    }

    /**
     * 清除未读消息
     *
     * @param str
     * @return
     */
    @PutMapping("/unread/clear")
    public ResponseData clearUnreadMsg(@NonNull @RequestBody String str) {
        Integer fromId = JSON.parseObject(str).getInteger("fromId");
        msgHistoryService.clearUnreadMsg(fromId, getUserId());
        return Response.ok();
    }
}
