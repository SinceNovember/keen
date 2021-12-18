package com.simple.chat.server.handler;

import com.simple.common.utils.StringUtils;
import com.simple.common.utils.UriUtils;
import com.simple.system.model.entity.User;
import com.simple.system.service.UserService;
import com.simple.system.service.UserTokenService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 处理消息授权Handler
 */
@Slf4j
@Component
@ChannelHandler.Sharable
public class OAuthFilterHandler extends ChannelInboundHandlerAdapter {

    @Resource
    private UserTokenService userTokenService;

    @Resource
    private UserService userService;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof FullHttpRequest) {
            FullHttpRequest request = (FullHttpRequest) msg;
            String token = UriUtils.resolveParams(request.uri()).get("token");
            if (StringUtils.isEmpty(token)) {
                ctx.close();
            } else {
                try{
                    Integer userId = userTokenService.verityUserToken(token);
                    User user = userService.getById(userId);
                    if (!Objects.isNull(user)) {
                        request.setUri("/ws");
                        ctx.fireChannelRead(msg);
                    } else {
                        ctx.close();
                    }
                } catch (ExpiredCredentialsException e){
                    ctx.close();
                }
            }

        } else if(msg instanceof TextWebSocketFrame){
            ctx.fireChannelRead(msg);
        }
    }

}
