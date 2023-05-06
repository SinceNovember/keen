package com.simple.keen.kafka.consumer;

import com.simple.keen.kafka.message.LoginLogMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/5
 */
@Slf4j
@Component
public class LoginLogConsumer {

    @KafkaListener(topics = LoginLogMessage.TOPIC,
        groupId = "consumer-group-" + LoginLogMessage.TOPIC)
    public void onMessage(LoginLogMessage message, Acknowledgment acknowledgment) {
        try {
            log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(),
                message);
            acknowledgment.acknowledge();
        } catch (Exception e) {
            log.error("message consumer error!", e);
        }
    }
}
