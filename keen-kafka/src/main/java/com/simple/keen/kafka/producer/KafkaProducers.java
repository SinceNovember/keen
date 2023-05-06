package com.simple.keen.kafka.producer;

import com.simple.keen.kafka.message.LoginLogMessage;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/4
 */
public enum KafkaProducers {

    LOGIN_LOG(LoginLogMessage.TOPIC);

    private String topic;

    private static CommonProducer commonProducer;

    KafkaProducers(String topic) {
        this.topic = topic;
    }

    public void sendSync(Object msg) {
        commonProducer.syncSend(topic, msg);
    }

    public void sendAsync(Object msg) {
        commonProducer.asyncSend(topic, msg);
    }

    @Component
    static class Holder {

        @Resource
        private CommonProducer commonProducer;

        @PostConstruct
        private void postConstruct() {
            KafkaProducers.commonProducer = commonProducer;
        }
    }

}
