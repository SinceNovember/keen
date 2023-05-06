package com.simple.keen.server.handler;

import cn.dev33.satoken.stp.StpUtil;
import com.simple.keen.common.utils.StringUtils;
import com.simple.keen.common.utils.ThreadLocalUtils;
import com.simple.keen.common.utils.UriUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 权限过滤处理器
 *
 * @author SinceNovember
 * @date 2023/3/14
 */
@Slf4j
@Component
@RequiredArgsConstructor
@ChannelHandler.Sharable
public class AuthFilterHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof FullHttpRequest) {
            FullHttpRequest request = (FullHttpRequest) msg;
            String token = UriUtils.resolveParams(request.uri()).get("token");
            if (StringUtils.isBlank(token)) {
                ctx.close();
            } else {
                Object loginId = StpUtil.getLoginIdByToken(token);
                if (loginId != null) {
                    request.setUri("/ws");
                    ThreadLocalUtils.set("userId", Integer.valueOf(loginId.toString()));
                    ctx.fireChannelRead(msg);
                } else {
                    ctx.close();
                }
            }
        } else if (msg instanceof TextWebSocketFrame) {
            ctx.fireChannelRead(msg);
        }
    }

}
