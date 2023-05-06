package com.simple.keen.kafka.producer;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/4
 */
@Slf4j
@Component
public class CommonProducer implements Producer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @Override
    public SendResult syncSend(String topic, Object data) {
        try {
            return asyncSend(topic, data).get();
        } catch (Exception e) {
            log.info("同步信息发送失败!", e);
        }
        return null;
    }

    @Override
    public ListenableFuture<SendResult<Object, Object>> asyncSend(String topic, Object data) {
        try {
            return kafkaTemplate.send(topic, data);
        } catch (Exception e) {
            log.info("异步信息发送失败!", e);
        }
        return null;
    }

}
